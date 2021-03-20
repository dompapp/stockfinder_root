package at.papp.stockfinder.repository;

import at.papp.stockfinder.model.AbstractProduct;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<AbstractProduct, Integer> {

}
