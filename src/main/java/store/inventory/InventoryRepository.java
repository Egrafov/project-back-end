package store.inventory;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    @Modifying
    @Query("update Inventory i set i.available = ?1 where i.id = ?2")
    @Transactional
    void updateProductAvailability(Integer available, Long productId);
}
