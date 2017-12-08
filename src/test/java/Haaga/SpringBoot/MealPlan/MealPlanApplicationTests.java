package Haaga.SpringBoot.MealPlan;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Haaga.SpringBoot.MealPlan.Web.FoodController;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealPlanApplicationTests {
	@Autowired
	private FoodController controller;
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
