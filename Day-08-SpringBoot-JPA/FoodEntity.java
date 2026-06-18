package com.abc.demo.FirstSpringBootMavenProject;

import org.springframework.context.annotation.ComponentScan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "foods")
public class FoodEntity {

	@Id
	private int foodID;
	private String foodName;
	private int foodCost;
	private int foodRating;
	
	public FoodEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodEntity(int foodID, String foodName, int foodCost, int foodRating) {
		super();
		this.foodID = foodID;
		this.foodName = foodName;
		this.foodCost = foodCost;
		this.foodRating = foodRating;
	}
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodCost() {
		return foodCost;
	}
	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}
	public int getFoodRating() {
		return foodRating;
	}
	public void setFoodRating(int foodRating) {
		this.foodRating = foodRating;
	}
	
	
}