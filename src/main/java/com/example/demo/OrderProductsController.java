package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order-products")
@RestController
public class OrderProductsController {
    @Autowired
    private OrderProductsRepository orderProductsRepository;

//    @DeleteMapping("/order_products/{id}")
//    public ResponseEntity<Void> deleteOrderProduct(@PathVariable Integer id) {
//        if (orderProductsRepository.existsById(new OrderProductsId(id))) {
//            orderProductsRepository.deleteById(new OrderProductsId(id));
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/{orderId}/{productId}")
    public ResponseEntity<OrderProduct> postBody(@RequestBody OrderProduct orderProduct) {
        OrderProduct saved = orderProductsRepository.save(orderProduct);
        return new ResponseEntity<OrderProduct>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}/{productId}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public Iterable<OrderProduct> getAllOrderProducts() {

        for (OrderProduct p : orderProductsRepository.findAll()
        ) {
            System.out.println(p.getOrderID());
        }
        return orderProductsRepository.findAll();
    }


}