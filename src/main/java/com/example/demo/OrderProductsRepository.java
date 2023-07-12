package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface OrderProductsRepository extends CrudRepository<OrderProduct, OrderProductsId> {

}
