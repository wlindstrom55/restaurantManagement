package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.promineotech.restaurantManagement.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
