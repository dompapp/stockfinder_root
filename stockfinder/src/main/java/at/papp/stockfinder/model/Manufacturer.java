package at.papp.stockfinder.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Manufacturer {

    @Id
    @Column(name = "manufacturer_Id")
    private Long manufacturerId;
    @Column(name = "manufacturer_Name")
    private String manufacturerName;

}

