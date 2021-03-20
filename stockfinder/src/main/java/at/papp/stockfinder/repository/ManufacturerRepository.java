package at.papp.stockfinder.repository;

import at.papp.stockfinder.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

}
