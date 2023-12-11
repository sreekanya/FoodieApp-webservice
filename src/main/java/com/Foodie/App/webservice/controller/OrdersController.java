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
import com.Foodie.App.webservice.entity.Menu;
import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/orders")
	public List<Orders> getOrders(){
		return ordersService.getAllOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseDto getOrder(@PathVariable int orderId){
		
		Optional<Orders> order = ordersService.getOneOrder(orderId);
		return new ResponseDto("Order is found sucessfully with orderId : "+orderId, new Date(),HttpStatus.OK.name(),order);

	}
	
	@PostMapping("/orders")
	public ResponseDto addOrder(@RequestBody Orders order){
		
		 Orders newOrder =  ordersService.addOrder(order);
		 return new ResponseDto("Menu is created sucessfully ", new Date(),HttpStatus.OK.name(),newOrder);
	}
	
	@PutMapping("/orders")
	public ResponseDto updateOrder(@RequestBody Orders order) {
		
		Orders orderUpdated = ordersService.updateOrder(order);
		return new ResponseDto("Menu is updated sucessfully.", new Date(),HttpStatus.OK.name(),orderUpdated);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseDto deleteOrder(@PathVariable int orderId){
		ordersService.deleteOrder(orderId);
		return new ResponseDto("Order is deleted sucessfully with orderId : "+orderId,new Date(),HttpStatus.OK.name(),null);
	}

}
