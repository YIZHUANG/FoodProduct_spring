package Haaga.SpringBoot.MealPlan.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductType {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long typeId;
private String typeName;

@OneToMany(cascade =CascadeType.ALL, mappedBy = "type")
private List <FoodList> food;

public ProductType(){}
public ProductType(String typeName){
	super();
	this.typeName=typeName;
}
public Long getTypeId() {
	return typeId;
}
public void setTypeId(Long typeId) {
	this.typeId = typeId;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
public List<FoodList> getFood() {
	return food;
}
public void setFood(List<FoodList> food) {
	this.food = food;
}
}
