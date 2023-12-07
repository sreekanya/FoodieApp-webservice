package com.Foodie.App.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Foodie.App.webservice.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
