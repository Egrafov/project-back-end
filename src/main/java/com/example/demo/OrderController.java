package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> postBody(@RequestBody Order order) {
        Order saved = orderRepository.save(order);
        return new ResponseEntity<Order>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public Iterable<Order> getAllOrders() {

        for (Order p : orderRepository.findAll()
        ) {
            System.out.println(p.getId());
        }
        return orderRepository.findAll();
    }


}

