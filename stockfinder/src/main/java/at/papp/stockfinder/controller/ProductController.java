package at.papp.stockfinder.controller;


import at.papp.stockfinder.model.Product;
import at.papp.stockfinder.repository.ProductRepository;
import at.papp.stockfinder.repository.impl.ProductRepositoryImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    private ProductRepositoryImpl productRepositoryImpl;

    @GetMapping("/products")
    public List<Product> getProducts() {
       //System.out.println(Lists.newArrayList(productRepository.findAll()));
        return Lists.newArrayList(productRepository.findAll());
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        //System.out.println("Adding product: " + product);
        productRepository.save(product);
    }

}
