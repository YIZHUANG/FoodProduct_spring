package Haaga.SpringBoot.MealPlan.Domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MarketRepository extends CrudRepository<MarketList,Long>{
List<MarketList> findByMarketName(String marketName);
}
