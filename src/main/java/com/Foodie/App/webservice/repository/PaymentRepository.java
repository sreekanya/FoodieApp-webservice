package com.Foodie.App.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.entity.Payment;
import com.Foodie.App.webservice.entity.Restaurants;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

//	boolean existsByEmail(String email);
//
//	Payment findByEmail(String email);
	boolean existsByOrderId(Orders orders);
	
}
