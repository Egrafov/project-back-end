package com.example.demo;

import java.io.Serializable;

public class OrderProductsId implements Serializable {

    private Integer orderID;
    private Integer productId;

    // Default constructor
    public OrderProductsId() {
    }

    // Constructor with primary key values
    public OrderProductsId(Integer orderID, Integer productId) {
        this.orderID = orderID;
        this.productId = productId;
    }

    // Getters and setters (omitted for brevity)

    // Override equals() and hashCode() methods (omitted for brevity)
}

