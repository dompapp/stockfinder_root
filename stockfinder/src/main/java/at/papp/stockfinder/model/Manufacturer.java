package at.papp.stockfinder.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANUFACTURER_ID")
    private Long manufacturerId;
    @Column(name = "MANUFACTURER_NAME")
    private String manufacturerName;

}

