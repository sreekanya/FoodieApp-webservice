package com.Foodie.App.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Users;
import com.Foodie.App.webservice.exception.BadRequestException;
import com.Foodie.App.webservice.exception.NotFoundException;
import com.Foodie.App.webservice.repository.UsersRepository;
import com.Foodie.App.webservice.util.StringUtil;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	//Get All Users
	public List<Users> getUsers(){
		return usersRepository.findAll();
	}
	
	//Get one User by UserId
	public Optional<Users> getUser(int UserId) {
		//return usersRepository.findById(UserId);
		
		Optional<Users> user = usersRepository.findById(UserId);
		if(user.isPresent() && StringUtil.isNotNull(user))
			return user;
		else 
			throw new NotFoundException("Users with provided userId not found");
	}
	
	//Add User
	public Users addUser(Users user) {
		//return usersRepository.save(user);
		
		if(usersRepository.existsByEmail(user.getEmail()))
			throw new BadRequestException("User with this email address already exists.");

		return usersRepository.save(user);
	}
	
	//Update User
	public Users updateUser(Users user) {
		
		if(user.getUserId() <=0 )
			throw new BadRequestException("userId cannot be null or empty.");

		if(usersRepository.existsById(user.getUserId()))
			return usersRepository.save(user);
		else 
			throw new NotFoundException("The user does not exist with provided userId.");
				
	}
	
	//Delete User
	public void deleteUser(int userId) {
				
		if(userId <=0 )
			throw new BadRequestException("userId cannot be null or empty.");
		if(usersRepository.existsById(userId))
			usersRepository.deleteById(userId);
		else 
			throw new NotFoundException("The user does not exist with provided userId.");
	}
}
