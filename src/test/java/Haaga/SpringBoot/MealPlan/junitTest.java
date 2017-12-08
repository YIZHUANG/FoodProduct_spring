package Haaga.SpringBoot.MealPlan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import Haaga.SpringBoot.MealPlan.Domain.FoodRepository;
import Haaga.SpringBoot.MealPlan.Domain.MarketList;
import Haaga.SpringBoot.MealPlan.Domain.MarketRepository;
import Haaga.SpringBoot.MealPlan.Domain.ProductType;
import Haaga.SpringBoot.MealPlan.Domain.ProductTypeRepository;
import Haaga.SpringBoot.MealPlan.Domain.FoodList;
import Haaga.SpringBoot.MealPlan.Domain.FoodRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class junitTest {
	
	@Autowired
	private FoodRepository repository;
	@Autowired
	private MarketRepository mrepository;
	@Autowired
	private ProductTypeRepository trepository;

	
	@Test
	public void findByMarkeyName(){
		List<MarketList> MarketList = mrepository.findByMarketName("Kmarket");
		assertThat(MarketList).hasSize(1);
		assertThat(MarketList.get(0).getMarketName()).isEqualTo("Kmarket");
	}
	
	@Test
	public void findByFoodName(){
		List<FoodList> FoodList = repository.findByName("Minced beef");
		assertThat(FoodList).hasSize(1);
		assertThat(FoodList.get(0).getName()).isEqualTo("Minced beef");
	}
	
	@Test
	public void createNewMarket(){
		MarketList marketList =new MarketList("Lidl");
		mrepository.save(marketList);
		assertThat(marketList.getMarketId()).isNotNull();
}

}