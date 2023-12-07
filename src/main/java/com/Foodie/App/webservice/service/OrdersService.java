package com.Foodie.App.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.repository.OrdersRepository;


@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	//Get All Orders
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();
	}
	
	//Get one Order by orderId
	public Orders getOneOrder(int orderId) {
		return ordersRepository.findById(orderId).get();
	}
	
	//Add Order
	public Orders addOrder(Orders order) {
		return ordersRepository.save(order);
	}
	
	//Update Order
	public Orders updateOrder(Orders order) {
		if(ordersRepository.existsById(order.getOrderId()))
			return ordersRepository.save(order);
		else
			return null;
				
	}
	
	//Delete Order
	public void deleteOrder(int orderId) {
		ordersRepository.deleteById(orderId);
				
	}
}
