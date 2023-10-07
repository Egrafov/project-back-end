package store.orders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.inventory.InventoryRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductsRepository orderProductsRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newOrder")
    public ResponseEntity<?> createNewOrder(@RequestBody OrderRequest orderRequest) {
        var orderToSave = new Order(orderRequest);
        Order saved = orderRepository.save(orderToSave);
        var orderId = saved.getId();
        for (var orderedProduct : orderRequest.productQuantities
        ) {
            var productId = orderedProduct.productId;
            var orderedQuantity = orderedProduct.quantity;
            orderProductsRepository.save(new OrderProduct(orderId, productId, orderedQuantity));

            var inventoryItem = inventoryRepository.findById(productId);
            if (inventoryItem.isEmpty()) {
                return ResponseEntity.badRequest().body("No such product");
            } else {
                var item = inventoryItem.get();
                item.setAvailable(item.getAvailable() - orderedQuantity);
                inventoryRepository.save(item);
            }
        }

        return new ResponseEntity<Order>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/{orderId}/{newStatus}")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable Integer orderId, @PathVariable OrderStatus newStatus) {
        orderRepository.updateOrderStatus(newStatus, orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    @ResponseBody
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

