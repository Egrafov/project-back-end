package store.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class ProductInventory {
    @Id
    Long id;
    private String category;
    private String description;
    private String name;
    private Double price;
    private Integer available;
    @Lob
    @Column(name = "image_data", columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;

    public Long getId() {
        return id;
    }

    public void setId(Long productId) {
        this.id = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
