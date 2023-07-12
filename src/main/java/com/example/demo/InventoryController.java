package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Integer id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/inventory")
    public ResponseEntity<Inventory> postBody(@RequestBody Inventory inventory) {
        Inventory saved = inventoryRepository.save(inventory);
        return new ResponseEntity<Inventory>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/inventory")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public Iterable<Inventory> getAllInventory() {

        for (Inventory p : inventoryRepository.findAll()
        ) {
            System.out.println(p.getId());
        }
        return inventoryRepository.findAll();
    }


}


