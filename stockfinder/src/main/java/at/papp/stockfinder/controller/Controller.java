package at.papp.stockfinder.controller;


import at.papp.stockfinder.repository.ProductRepository;
import at.papp.stockfinder.repository.impl.ProductRepositoryImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ProductRepository productRepository;

    private ProductRepositoryImpl productRepositoryImpl;

    @RequestMapping("/")
    public String index() {
        return "here is index";
    }

    @RequestMapping("/justin")
    public String justin() {
        return "Grüße an den Burzi";
    }

    @RequestMapping("/products")
    public String getProducts() {
//        try {
//            return Lists.newArrayList(productRepository.findAll()).toString();
//        } catch (NullPointerException e) {
//            System.out.println("Exception: " + e.getMessage());
//            return "no products found";
//        }
        List<String> lst = new ArrayList<>();
        lst.add("Product 1");
        lst.add("Product 2");
        return lst.toString();
    }

}
