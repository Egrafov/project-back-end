package store.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "product_id")
    private Long id;
    @Column
    private Integer available;

    public Inventory() {
    }

    public Inventory(Long id, Integer available) {
        this.id = id;
        this.available = available;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
