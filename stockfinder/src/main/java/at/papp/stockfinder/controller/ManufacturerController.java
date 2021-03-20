package at.papp.stockfinder.controller;


import at.papp.stockfinder.model.Manufacturer;
import at.papp.stockfinder.model.Product;
import at.papp.stockfinder.repository.ManufacturerRepository;
import at.papp.stockfinder.repository.ProductRepository;
import at.papp.stockfinder.repository.impl.ProductRepositoryImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getProducts() {
        return Lists.newArrayList(manufacturerRepository.findAll());
    }

    @PostMapping("/manufacturers")
    void addProduct(@RequestBody Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

}
