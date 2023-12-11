package com.Foodie.App.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Restaurants;
import com.Foodie.App.webservice.exception.BadRequestException;
import com.Foodie.App.webservice.exception.NotFoundException;
import com.Foodie.App.webservice.repository.RestaurantsRepository;
import com.Foodie.App.webservice.util.StringUtil;

@Service
public class RestaurantsService {

	@Autowired
	RestaurantsRepository restaurantsRepository;
	
	//Get All Restaurants
	public List<Restaurants> getRestaurants(){
		return restaurantsRepository.findAll();
	}
	
	//Get one Restaurant by RestaurantId
	public Optional<Restaurants> getRestaurant(int restaurantId) {

		Optional<Restaurants> restaurant = restaurantsRepository.findById(restaurantId);
		if(restaurant.isPresent() && StringUtil.isNotNull(restaurant))
			return restaurant;
		else 
			throw new NotFoundException("Restaurant with provided restaurantId not found");
	}
	
	//Add Restaurant
	public Restaurants addRestaurant(Restaurants restaurant) {
	
		if(restaurantsRepository.existsByRestaurantEmail(restaurant.getRestaurantEmail()))
			throw new BadRequestException("Restaurant with this email address already exists.");

		return restaurantsRepository.save(restaurant);
	}
	
	//Update Restaurant
	public Restaurants updateRestaurant(Restaurants restaurant) {
		
		if(restaurant.getRestaurantId() <=0 )
			throw new BadRequestException("restaurantId cannot be null or empty.");

		if(restaurantsRepository.existsById(restaurant.getRestaurantId()))
			return restaurantsRepository.save(restaurant);
		else 
			throw new NotFoundException("The Restaurant does not exist with provided restaurantId.");
				
	}
	
	//Delete Restaurant
	public void deleteRestaurant(int restaurantId) {
		
		if(restaurantId <=0 )
			throw new BadRequestException("userId cannot be null or empty.");
		if(restaurantsRepository.existsById(restaurantId))
			restaurantsRepository.deleteById(restaurantId);
		else 
			throw new NotFoundException("The Restaurant does not exist with provided restaurantId.");
				
	}
}
