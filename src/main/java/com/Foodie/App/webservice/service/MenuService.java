package com.Foodie.App.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Menu;
import com.Foodie.App.webservice.repository.MenuRepository;


@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;
	
	//Get All Menus
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}
	
	//Get one Menu by menuId
	public Menu getOneMenu(int menuId) {
		return menuRepository.findById(menuId).get();
	}
	
	//Add Menu
	public Menu addMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	//Update Menu
	public Menu updateMenu(Menu menu) {
		if(menuRepository.existsById(menu.getMenuId()))
			return menuRepository.save(menu);
		else
			return null;
				
	}
	
	//Delete Menu
	public void deleteMenu(int menuId) {
		menuRepository.deleteById(menuId);
				
	}
}
