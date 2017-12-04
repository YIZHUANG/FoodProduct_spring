package Haaga.SpringBoot.MealPlan.Domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface FoodRepository extends CrudRepository<FoodList,Long>{
	List<FoodList> findByName(String name);
}
