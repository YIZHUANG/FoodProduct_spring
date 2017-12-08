package Haaga.SpringBoot.MealPlan.Domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class FoodList {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String name;
    private double price;
    private String description;
    private double calories;
    private String marketlocation;
    private String imgURL;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="marketId")
    private MarketList market;
   
   @ManyToOne
   @JsonIgnore
   @JoinColumn(name="typeId") 
   private ProductType type;

	public FoodList() {}

	public FoodList(String name, double price,String description,double calories,String marketlocation,String imgURL,MarketList market,ProductType type) {
		super();
		this.name=name;
		this.price=price;
		this.description=description;
		this.calories=calories;
		this.marketlocation=marketlocation;
		this.market=market;
		this.type=type;
		this.imgURL=imgURL;
		}
	
	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public String getMarketlocation() {
		return marketlocation;
	}

	public void setMarketlocation(String marketlocation) {
		this.marketlocation = marketlocation;
	}

	public MarketList getMarket() {
		return market;
	}

	public void setMarket(MarketList market) {
		this.market = market;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}


}