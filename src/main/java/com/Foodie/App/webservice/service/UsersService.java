package com.Foodie.App.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Users;
import com.Foodie.App.webservice.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	//Get All Users
	public List<Users> getUsers(){
		return usersRepository.findAll();
	}
	
	//Get one User by UserId
	public Users getUser(int UserId) {
		return usersRepository.findById(UserId).get();
	}
	
	//Add User
	public Users addUser(Users user) {
		return usersRepository.save(user);
	}
	
	//Update User
	public Users updateUser(Users user) {
		if(usersRepository.existsById(user.getUserId()))
			return usersRepository.save(user);
		else
			return null;
				
	}
	
	//Delete User
	public void deleteUser(int userId) {
		usersRepository.deleteById(userId);
				
	}
}
