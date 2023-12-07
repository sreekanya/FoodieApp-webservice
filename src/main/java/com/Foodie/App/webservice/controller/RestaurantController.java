package com.Foodie.App.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Restaurants getRestaurant(@PathVariable int restaurantId){
		return restaurantService.getRestaurant(restaurantId);
	}
	
	@PostMapping("/restaurants")
	public Restaurants addRestaurant(@RequestBody Restaurants restaurant){
		return restaurantService.addRestaurant(restaurant);
	}
	
	@PutMapping("/restaurants")
	public Restaurants updateRestaurant(@RequestBody Restaurants restaurant) {
		return restaurantService.updateRestaurant(restaurant);
	}
	
	@DeleteMapping("/restaurants/{restaurantId}")
	public ResponseDto deleteRestaurant(@PathVariable int restaurantId){
		restaurantService.deleteRestaurant(restaurantId);
		return new ResponseDto("Restaurant is deleted sucessfully with restaurantId : "+restaurantId);
	}

}
