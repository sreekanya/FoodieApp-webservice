package com.Foodie.App.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Foodie.App.webservice.entity.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
