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
import com.Foodie.App.webservice.entity.Users;
import com.Foodie.App.webservice.exception.NotFoundException;
import com.Foodie.App.webservice.service.UsersService;
import com.Foodie.App.webservice.util.StringUtil;

@RestController
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseDto getUser(@PathVariable int userId){
		
		Optional<Users> users = userService.getUser(userId);
		return new ResponseDto("User is found sucessfully with userId : "+userId, new Date(),HttpStatus.OK.name(),users);
		
	}
	
	@PostMapping("/users")
	public ResponseDto addUser(@RequestBody Users user){
		Users newuser = userService.addUser(user);
		return new ResponseDto("User is created sucessfully.", new Date(),HttpStatus.OK.name(),newuser);
	}
	
	@PutMapping("/users")
	public ResponseDto updateUser(@RequestBody Users user) {
		
		Users userUpdated = userService.updateUser(user);
		return new ResponseDto("User is updated sucessfully.", new Date(),HttpStatus.OK.name(),userUpdated);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseDto deleteUser(@PathVariable int userId){
		userService.deleteUser(userId);
		return new ResponseDto("User is deleted sucessfully with userId : "+userId, new Date(),HttpStatus.OK.name(),null);
		
	}

}
