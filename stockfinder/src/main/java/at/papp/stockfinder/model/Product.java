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
        this.productId = 0L;
        this.productName = "Default name";
        this.productMaxPrice = 0.00;
    }

    public Product(String productName, Double maxProductPrice) {
        this.productName = productName;
        this.productMaxPrice = maxProductPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productId=").append(productId);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productMaxPrice=").append(productMaxPrice);
        sb.append('}');
        return sb.toString();
    }
}

