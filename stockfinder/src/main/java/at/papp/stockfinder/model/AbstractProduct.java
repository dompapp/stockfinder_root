package at.papp.stockfinder.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCT")
public class AbstractProduct implements IProduct {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    Long productId;
    @Column(name = "PRODUCT_NAME")
    @ToString.Include
    String productName;
    @ToString.Include
    @Column(name = "PRODUCT_MAX_PRICE")
    Double productMaxPrice;

    public AbstractProduct(String productName, Double maxProductPrice) {
        this.productName = productName;
        this.productMaxPrice = maxProductPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractProduct{");
        sb.append("productId=").append(productId);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productMaxPrice=").append(productMaxPrice);
        sb.append('}');
        return sb.toString();
    }
}

