package Haaga.SpringBoot.MealPlan.Domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface ProductTypeRepository extends CrudRepository<ProductType,Long>{
	List<ProductType> findBytypeName(String typeName);

}
