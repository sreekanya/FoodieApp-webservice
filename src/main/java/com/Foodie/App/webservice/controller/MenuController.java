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
import com.Foodie.App.webservice.entity.Menu;
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
	public Menu getMenu(@PathVariable int menuId){
		return menuService.getOneMenu(menuId);
	}
	
	@PostMapping("/menus")
	public Menu addMenu(@RequestBody Menu menu){
		return menuService.addMenu(menu);
	}
	
	@PutMapping("/menus")
	public Menu updateMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}
	
	@DeleteMapping("/menus/{menuId}")
	public ResponseDto deleteMenu(@PathVariable int menuId){
		menuService.deleteMenu(menuId);
		return new ResponseDto("Menu is deleted sucessfully with menuId : "+menuId);
	}

}
