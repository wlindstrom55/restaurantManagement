package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.restaurantManagement.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	 public User findByuserName(String userName); //Spring data can tell based on the method name, that it will search the db 
	 //for a user that has the username we passed in as the parameter.
}
