package at.papp.stockfinder.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product implements IProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRODUCT_NAME")
    @ToString.Include
    private String productName;
    @ToString.Include
    @Column(name = "PRODUCT_MAX_PRICE")
    private Double productMaxPrice;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_MANUFACTURER_ID")
    private Manufacturer manufacturer;

    public Product() {
        this("Unknown");
    }

    public Product(String productName) {
        this(productName, 0.00);
    }

    public Product(String productName, Double maxProductPrice) {
        this(productName, maxProductPrice, -1L);
    }

    public Product(String productName, Double maxProductPrice, Long productId) {
        this.productName = productName;
        this.productMaxPrice = maxProductPrice;
        this.productId = productId;
    }

    @Override
    public String toString() {
        String sb = "Product{" + "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productMaxPrice=" + productMaxPrice +
                '}';
        return sb;
    }
}

