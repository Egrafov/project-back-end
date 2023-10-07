package store.orders;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Modifying
    @Query("update Order o set o.status = ?1 where o.id = ?2")
    @Transactional
    void updateOrderStatus(OrderStatus status, Integer orderId);
}

