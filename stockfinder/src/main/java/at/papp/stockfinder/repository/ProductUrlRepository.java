package at.papp.stockfinder.repository;

import at.papp.stockfinder.model.ProductUrl;
import org.springframework.data.repository.CrudRepository;

public interface ProductUrlRepository extends CrudRepository<ProductUrl, Long> {
}
