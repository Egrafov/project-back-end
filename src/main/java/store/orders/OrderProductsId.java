package store.orders;

import jakarta.persistence.Column;

import java.io.Serializable;

public class OrderProductsId implements Serializable {

    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "product_id")
    private Long productId;

    // Default constructor
    public OrderProductsId() {
    }

    // Constructor with primary key values
    public OrderProductsId(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // Getters and setters (omitted for brevity)

    // Override equals() and hashCode() methods (omitted for brevity)
}

