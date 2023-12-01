package store.products;


import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private MultipartFile uploadImage;
    @Lob
    @Column(name = "image_data", columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private String name;
    @Column
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", uploadImage=" + uploadImage +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public MultipartFile getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(MultipartFile uploadImage) {
        this.uploadImage = uploadImage;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

