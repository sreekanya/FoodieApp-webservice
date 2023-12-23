package com.Foodie.App.webservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="restaurants")
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restaurant_id")
	private int restaurantId;
	
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@Column(name = "restaurant_email")
	private String restaurantEmail;
	
	@Column(name="restaurant_phone")
	private String restaurantPhone;
	
	@Column(name="restaurant_address")
	private String restaurantAddress;
	
	@Column(name="image_link")
	private String imageLink;
	
	public Restaurants() {}

	

	public Restaurants(int restaurantId, String restaurantName, String restaurantEmail, String restaurantPhone,
			String restaurantAddress, String imageLink) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantEmail = restaurantEmail;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddress = restaurantAddress;
		this.imageLink = imageLink;
	}



	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", restaurantEmail="
				+ restaurantEmail + ", restaurantPhone=" + restaurantPhone + ", restaurantAddress=" + restaurantAddress
				+ ", imageLink=" + imageLink + "]";
	}

	
	
}
