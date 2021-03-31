package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.restaurantManagement.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>  {

}
