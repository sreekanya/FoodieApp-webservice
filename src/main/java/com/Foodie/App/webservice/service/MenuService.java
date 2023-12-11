package com.Foodie.App.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Menu;
import com.Foodie.App.webservice.exception.BadRequestException;
import com.Foodie.App.webservice.exception.NotFoundException;
import com.Foodie.App.webservice.repository.MenuRepository;
import com.Foodie.App.webservice.util.StringUtil;


@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;
	
	//Get All Menus
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}
	
	//Get one Menu by menuId
	public Optional<Menu> getOneMenu(int menuId) {
		
		Optional<Menu> menu = menuRepository.findById(menuId);
		if(menu.isPresent() && StringUtil.isNotNull(menu))
			return menu;
		else 
			throw new NotFoundException("Menu with provided menuId not found");
	}
	
	//Add Menu
	public Menu addMenu(Menu menu) {
		
		if(menuRepository.existsByItemName(menu.getItemName()) && menuRepository.existsByRestaurantId(menu.getRestaurantId()))
			throw new BadRequestException("Menu with this name in the Restaurant  already exists.");

		return menuRepository.save(menu);
	}
	
	//Update Menu
	public Menu updateMenu(Menu menu) {
		
		if(menu.getMenuId() <=0 )
			throw new BadRequestException("menuId cannot be null or empty.");

		if(menuRepository.existsById(menu.getMenuId()))
			return menuRepository.save(menu);
		else 
			throw new NotFoundException("Menu does not exist with provided menuId.");
				
	}
	
	//Delete Menu
	public void deleteMenu(int menuId) {
		
		if(menuId <=0 )
			throw new BadRequestException("menuId cannot be null or empty.");
		if(menuRepository.existsById(menuId))
			menuRepository.deleteById(menuId);
		else 
			throw new NotFoundException("Menu does not exist with provided menuId.");
				
	}
}
