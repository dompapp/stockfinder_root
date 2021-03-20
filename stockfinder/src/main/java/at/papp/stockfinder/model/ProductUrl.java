package at.papp.stockfinder.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT_URL")
public class ProductUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_URL_ID")
    private Long productUrlId;

    @Column(name = "PRODUCT_URL_URI")
    private String productUri;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_URL_PRODUCT_ID")
    private Product product;


}
