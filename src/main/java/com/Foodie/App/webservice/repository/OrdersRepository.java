package com.Foodie.App.webservice.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.entity.Restaurants;
import com.Foodie.App.webservice.entity.Users;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

//	boolean existsByEmail(String email);
//
//	Orders findByEmail(String email);
	
	boolean existsByRestaurantId(Restaurants restaurants);
	
	boolean existsByUserId(Users users);
	boolean existsByOrderDate(Date orderDate);
}
