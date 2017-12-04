package Haaga.SpringBoot.MealPlan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Haaga.SpringBoot.MealPlan.Domain.FoodList;
import Haaga.SpringBoot.MealPlan.Domain.FoodRepository;
import Haaga.SpringBoot.MealPlan.Domain.MarketList;
import Haaga.SpringBoot.MealPlan.Domain.MarketRepository;
import Haaga.SpringBoot.MealPlan.Domain.ProductType;
import Haaga.SpringBoot.MealPlan.Domain.ProductTypeRepository;
import Haaga.SpringBoot.MealPlan.Domain.User;
import Haaga.SpringBoot.MealPlan.Domain.UserRepository;




@SpringBootApplication
public class MealPlanApplication {
	private static final Logger log = LoggerFactory.getLogger(MealPlanApplication.class);
		public static void main(String[] args) {
			SpringApplication.run(MealPlanApplication.class, args);
		}
		
		@Bean
		public CommandLineRunner studentDemo(FoodRepository repository,MarketRepository mrepository,ProductTypeRepository trepository,UserRepository urepository) {
			return (args) -> {
				log.info("save a couple of students");
				mrepository.save(new MarketList("Smarket"));
				mrepository.save(new MarketList("Kmarket"));
				mrepository.save(new MarketList("Alepa"));
				
				trepository.save(new ProductType("Protein"));
				trepository.save(new ProductType("Veggie"));
				trepository.save(new ProductType("Dessert"));
				
				repository.save(new FoodList("Minced beef",3.5,"finnish beef low fat",2000,"Hakaniemi","https://groceries.morrisons.com/productImages/302/302002011_0_640x640.jpg?identifier=704bfc91c0da55d0fb75a8557cc19a8a",mrepository.findBymarketName("Kmarket").get(0),trepository.findBytypeName("Protein").get(0)));
				repository.save(new FoodList("Salad",2.5,"organic with carrot and kale",600,"pasila","https://img.aws.livestrongcdn.com/ls-article-image-673/ds-photo/getty/article/144/14/494706637.jpg",mrepository.findBymarketName("Smarket").get(0),trepository.findBytypeName("Veggie").get(0)));
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);		
			};
	}
}
