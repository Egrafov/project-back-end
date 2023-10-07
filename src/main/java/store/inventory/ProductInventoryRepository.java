package store.inventory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductInventoryRepository extends CrudRepository<ProductInventory, Long> {
    @Query(value = "SELECT products.id, products.category, products.price, products.image_data, products.name, products.description, inventory.available\n" +
            "FROM products\n" +
            "left JOIN inventory ON inventory.product_id = products.id", nativeQuery = true)
    List<ProductInventory> getAllProductsInventory();
}
