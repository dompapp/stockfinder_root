package at.papp.stockfinder.repository;

import at.papp.stockfinder.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
