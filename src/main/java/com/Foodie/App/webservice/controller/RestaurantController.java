package com.Foodie.App.webservice.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Foodie.App.webservice.dto.ResponseDto;
import com.Foodie.App.webservice.entity.Restaurants;
import com.Foodie.App.webservice.entity.Users;
import com.Foodie.App.webservice.service.RestaurantsService;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantsService restaurantService;
	
	@GetMapping("/restaurants")
	public List<Restaurants> getAllRestaurants(){
		return restaurantService.getRestaurants();
	}
	
	@GetMapping("/restaurants/{restaurantId}")
	public ResponseDto getRestaurant(@PathVariable int restaurantId){
		
		Optional<Restaurants> restaurants = restaurantService.getRestaurant(restaurantId);
		return new ResponseDto("Restaurant is found sucessfully with restaurantId : "+restaurantId, new Date(),HttpStatus.OK.name(),restaurants);
	}
	
	@PostMapping("/restaurants")
	public ResponseDto addRestaurant(@RequestBody Restaurants restaurant){
		Restaurants newRestaurant =  restaurantService.addRestaurant(restaurant);
		
		return new ResponseDto("Restaurant is created sucessfully ", new Date(),HttpStatus.OK.name(),newRestaurant);
	}
	
	@PutMapping("/restaurants")
	public ResponseDto updateRestaurant(@RequestBody Restaurants restaurant) {
		
		Restaurants restaurantUpdated = restaurantService.updateRestaurant(restaurant);
		return new ResponseDto("Restaurant is updated sucessfully.", new Date(),HttpStatus.OK.name(),restaurantUpdated);
	}
	
	@DeleteMapping("/restaurants/{restaurantId}")
	public ResponseDto deleteRestaurant(@PathVariable int restaurantId){
		restaurantService.deleteRestaurant(restaurantId);
		return new ResponseDto("Restaurant is deleted sucessfully with restaurantId : "+restaurantId,new Date(),HttpStatus.OK.name(),null);
	}

}
