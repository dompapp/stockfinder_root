package at.papp.stockfinder.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT_URL")
public class ProductUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_URL_ID")
    private Long productUrlId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_URL_PRODUCT_ID")
    private AbstractProduct product;


}
