package store.orders;

import store.products.ProductQuantity;

import java.util.Date;

public class OrderRequest {
    public Date orderDate;
    public String userName;
    public Double totalSum;
    public String address;
    public ProductQuantity[] productQuantities;
}
