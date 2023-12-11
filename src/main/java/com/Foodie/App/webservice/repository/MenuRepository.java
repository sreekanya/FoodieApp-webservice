package com.Foodie.App.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Foodie.App.webservice.entity.Menu;
import com.Foodie.App.webservice.entity.Restaurants;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

	boolean existsByItemName(String itemName);

	Menu findByItemName(String itemName);
	
	boolean existsByRestaurantId(Restaurants restaurants);
	
}
