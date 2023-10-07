package store.orders;

import jakarta.persistence.*;

@IdClass(OrderProductsId.class)
@Entity
@Table(name = "order_products")
public class OrderProduct {
    @Id
    @Column(name = "order_id")
    private Long orderId;
    @Id
    @Column(name = "product_id")
    private Long productId;
    private Integer quantity;

    public OrderProduct() {
    }

    public OrderProduct(Long orderId, Long productId, Integer quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
}
