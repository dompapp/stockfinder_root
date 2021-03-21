package at.papp.stockfinder.controller;

import at.papp.stockfinder.model.ProductUrl;
import at.papp.stockfinder.repository.ProductUrlRepository;
import at.papp.stockfinder.service.ProductUrlService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductUrlController {

    @Autowired
    private ProductUrlRepository productUrlRepository;

    @Autowired
    private ProductUrlService productUrlService;

    @GetMapping("/urls")
    public List<ProductUrl> getUrls() {
        return Lists.newArrayList(productUrlRepository.findAll());
    }

    @PostMapping("/urls")
    void addUrl(@RequestBody ProductUrl url) {
        productUrlRepository.save(url);
    }

    @GetMapping("/urls/{id}")
    public String getContentOfUrlWithId(@PathParam("id") Long id) {
        id = 1L;
        System.out.println("id: " + id);
        System.out.println("found PU by Id: " + productUrlRepository.findById(id).get());
        return productUrlService.getContentOfProductUrl(productUrlRepository.findById(id).get());
    }

}
