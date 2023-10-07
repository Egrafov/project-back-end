package store.products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.inventory.Inventory;
import store.inventory.InventoryRepository;
import store.inventory.ProductInventory;
import store.inventory.ProductInventoryRepository;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
    //    @PostMapping(
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    public String uploadFilesProduct(Product product) {
//        log.info("product details: " + product);
//        // Add your processing logic here
//        return "success";
//    }
//    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseEntity<Product> uploadProduct(@ModelAttribute Product product) throws IOException {
////        product.setImageData(file.getBytes());
//        var saved = productRepository.save(product);
//        return ResponseEntity.status(HttpStatus.OK).body(saved);
//    }
    File destinationFile = new File("/test", "unique_filename.ext");
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductInventoryRepository productInventoryRepository;


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Product> uploadProduct(@ModelAttribute Product product) throws IOException {
//        product.setImageData(product.getUploadImage().getBytes());
//        product.setUploadImage(null);
        product.setImageData(product.getUploadImage().getBytes());
        product.setUploadImage(null);
        var saved = productRepository.save(product);
        inventoryRepository.save(new Inventory(saved.getId(), 0));
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @GetMapping()
    @ResponseBody
    public Iterable<Product> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        for (Product p : products) {
            System.out.println(p.getDescription());
        }
        return products;
    }

    @GetMapping("/inventory")
    @ResponseBody
    public Iterable<ProductInventory> getAllProductsInventory() {
//        for (var obj : productInventoryRepository.getAllProductsInventory()) {
//            System.out.println(obj);
//        }
        return productInventoryRepository.getAllProductsInventory();
//        return null;
    }
}

