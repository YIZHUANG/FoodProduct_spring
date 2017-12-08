package Haaga.SpringBoot.MealPlan.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
public class MarketList {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long marketId;
private String marketName;

@OneToMany(cascade =CascadeType.ALL, mappedBy = "market")
private List <FoodList> food;

public MarketList(){}
public MarketList(String marketName){
	super();
	this.marketName=marketName;
}
public Long getMarketId() {
	return marketId;
}
public void setMarketId(Long marketId) {
	this.marketId = marketId;
}
public String getMarketName() {
	return marketName;
}
public void setMarketName(String marketName) {
	this.marketName = marketName;
}
public List<FoodList> getFood() {
	return food;
}
public void setFood(List<FoodList> food) {
	this.food = food;
}



}