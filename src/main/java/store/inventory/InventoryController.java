package store.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/{productId}/{newCount}")
    public ResponseEntity<Void> setNewInventorySize(@PathVariable Long productId, @PathVariable Integer newCount) {
        inventoryRepository.updateProductAvailability(newCount, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public Iterable<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}


