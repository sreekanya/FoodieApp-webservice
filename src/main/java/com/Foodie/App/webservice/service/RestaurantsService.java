package com.Foodie.App.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Restaurants;
import com.Foodie.App.webservice.entity.Users;
import com.Foodie.App.webservice.repository.RestaurantsRepository;
import com.Foodie.App.webservice.repository.UsersRepository;

@Service
public class RestaurantsService {

	@Autowired
	RestaurantsRepository restaurantsRepository;
	
	//Get All Restaurants
	public List<Restaurants> getRestaurants(){
		return restaurantsRepository.findAll();
	}
	
	//Get one Restaurant by RestaurantId
	public Restaurants getRestaurant(int restaurantId) {
		return restaurantsRepository.findById(restaurantId).get();
	}
	
	//Add Restaurant
	public Restaurants addRestaurant(Restaurants restaurant) {
		return restaurantsRepository.save(restaurant);
	}
	
	//Update Restaurant
	public Restaurants updateRestaurant(Restaurants restaurant) {
		if(restaurantsRepository.existsById(restaurant.getRestaurantId()))
			return restaurantsRepository.save(restaurant);
		else
			return null;
				
	}
	
	//Delete Restaurant
	public void deleteRestaurant(int restaurantId) {
		restaurantsRepository.deleteById(restaurantId);
				
	}
}
