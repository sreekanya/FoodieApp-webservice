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
import com.Foodie.App.webservice.entity.Users;
import com.Foodie.App.webservice.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public Users getUser(@PathVariable int userId){
		return userService.getUser(userId);
	}
	
	@PostMapping("/users")
	public Users addUser(@RequestBody Users user){
		return userService.addUser(user);
	}
	
	@PutMapping("/users")
	public Users updateUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseDto deleteUser(@PathVariable int userId){
		userService.deleteUser(userId);
		return new ResponseDto("User is deleted sucessfully with userId : "+userId);
	}

}
