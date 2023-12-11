package com.Foodie.App.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.exception.BadRequestException;
import com.Foodie.App.webservice.exception.NotFoundException;
import com.Foodie.App.webservice.repository.OrdersRepository;
import com.Foodie.App.webservice.util.StringUtil;


@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	//Get All Orders
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();
	}
	
	//Get one Order by orderId
	public Optional<Orders> getOneOrder(int orderId) {
		
		Optional<Orders> order = ordersRepository.findById(orderId);
		if(order.isPresent() && StringUtil.isNotNull(order))
			return order;
		else 
			throw new NotFoundException("Order with provided orderId not found");
	}
	
	//Add Order
	public Orders addOrder(Orders order) {
		
		if(ordersRepository.existsByRestaurantId(order.getRestaurantId()) 
				&& ordersRepository.existsByUserId(order.getUserId())
				&& ordersRepository.existsByOrderDate(order.getOrderDate()))
			throw new BadRequestException("Order with same user and Restaurant on the same Date already exists.");

		return ordersRepository.save(order);
	}
	
	//Update Order
	public Orders updateOrder(Orders order) {
		
		if(order.getOrderId() <=0 )
			throw new BadRequestException("OrderId cannot be null or empty.");

		if(ordersRepository.existsById(order.getOrderId()))
			return ordersRepository.save(order);
		else 
			throw new NotFoundException("Order does not exist with provided orderId.");
				
				
	}
	
	//Delete Order
	public void deleteOrder(int orderId) {
		
		if(orderId <=0 )
			throw new BadRequestException("orderId cannot be null or empty.");
		if(ordersRepository.existsById(orderId))
			ordersRepository.deleteById(orderId);
		else 
			throw new NotFoundException("Order does not exist with provided orderId.");
				
	}
}
