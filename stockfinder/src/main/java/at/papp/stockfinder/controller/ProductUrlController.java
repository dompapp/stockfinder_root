package at.papp.stockfinder.controller;

import at.papp.stockfinder.model.ProductUrl;
import at.papp.stockfinder.repository.ProductUrlRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductUrlController {

    @Autowired
    private ProductUrlRepository productUrlRepository;

    @GetMapping("/urls")
    public List<ProductUrl> getUrls() {
        return Lists.newArrayList(productUrlRepository.findAll());
    }

    @PostMapping("/urls")
    void addUrl(@RequestBody ProductUrl url) {
        productUrlRepository.save(url);
    }

}
