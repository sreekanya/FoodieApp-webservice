package com.Foodie.App.webservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="menu")
public class Menu {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menu_id")
	private int menuId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="restaurant_id",nullable=false)
    private Restaurants restaurantId;
	
	@Column(name = "item_name")
    private String itemName;
	
	@Column(name = "price")
    private int price;
	
	@Column(name = "ingredients")
    private String ingredients;
	
	@Column(name = "category")
    private String category;
	
	@Column(name = "recipe_img")
    private String recipeImage;

	public Menu() {}
	

	public Menu(int menuId, Restaurants restaurantId, String itemName, int price, String ingredients, String category,
			String recipeImage) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.ingredients = ingredients;
		this.category = category;
		this.recipeImage = recipeImage;
	}



	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public Restaurants getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurants restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRecipeImage() {
		return recipeImage;
	}

	public void setRecipeImage(String recipeImage) {
		this.recipeImage = recipeImage;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", price="
				+ price + ", ingredients=" + ingredients + ", category=" + category + ", recipeImage=" + recipeImage
				+ "]";
	}
	
}
