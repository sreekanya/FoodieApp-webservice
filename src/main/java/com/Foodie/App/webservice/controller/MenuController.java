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
import com.Foodie.App.webservice.entity.Restaurants;
import com.Foodie.App.webservice.service.MenuService;


@RestController
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/menus")
	public List<Menu> getMenus(){
		return menuService.getAllMenu();
	}
	
	@GetMapping("/menus/{menuId}")
	public ResponseDto getMenu(@PathVariable int menuId){
		
		Optional<Menu> menu = menuService.getOneMenu(menuId);
		return new ResponseDto("Menu is found sucessfully with menuId : "+menuId, new Date(),HttpStatus.OK.name(),menu);

	}
	
	@PostMapping("/menus")
	public ResponseDto addMenu(@RequestBody Menu menu){
		
        Menu newMenu =  menuService.addMenu(menu);
		return new ResponseDto("Menu is created sucessfully ", new Date(),HttpStatus.OK.name(),newMenu);
	}
	
	@PutMapping("/menus")
	public ResponseDto updateMenu(@RequestBody Menu menu) {
		
		Menu menuUpdated = menuService.updateMenu(menu);
		return new ResponseDto("Menu is updated sucessfully.", new Date(),HttpStatus.OK.name(),menuUpdated);
	
	}
	
	@DeleteMapping("/menus/{menuId}")
	public ResponseDto deleteMenu(@PathVariable int menuId){
		menuService.deleteMenu(menuId);
		return new ResponseDto("Menu is deleted sucessfully with menuId : "+menuId,new Date(),HttpStatus.OK.name(),null);
	}

}
