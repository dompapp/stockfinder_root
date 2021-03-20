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

//    @RequestMapping("/")
//    public String index() {
//        return "here is index";
//    }
//
//    @RequestMapping("/justin")
//    public String justin() {
//        return "Grüße an den Burzi";
//    }

//    @RequestMapping("/products")
//    public String getProducts() {
//        try {
//            return Lists.newArrayList(productRepository.findAll()).toString();
//        } catch (NullPointerException e) {
//            System.out.println("Exception: " + e.getMessage());
//            return "no products found";
//        }
//        return null;
//    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @PostMapping("/products")
    void addProduct(@RequestBody Product product) {
        System.out.println("Adding product");
        productRepository.save(product);
    }

    @GetMapping("/strs")
    public List<String> getStrings() {
        List<String> lst = new ArrayList<>();
        lst.add("hai");
        lst.add("fisch");
        return lst;
    }

}
