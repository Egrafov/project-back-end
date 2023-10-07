package store.orders;

import org.springframework.data.repository.CrudRepository;

public interface OrderProductsRepository extends CrudRepository<OrderProduct, OrderProductsId> {


}

