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
	public Orders getOrder(@PathVariable int orderId){
		return ordersService.getOneOrder(orderId);
	}
	
	@PostMapping("/orders")
	public Orders addOrder(@RequestBody Orders order){
		return ordersService.addOrder(order);
	}
	
	@PutMapping("/orders")
	public Orders updateOrder(@RequestBody Orders order) {
		return ordersService.updateOrder(order);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseDto deleteOrder(@PathVariable int orderId){
		ordersService.deleteOrder(orderId);
		return new ResponseDto("Order is deleted sucessfully with orderId : "+orderId);
	}

}
