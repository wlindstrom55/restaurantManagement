package com.promineotech.restaurantManagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.restaurantManagement.entity.Restaurant;
import com.promineotech.restaurantManagement.repository.RestaurantRepository;


@Service
public class RestaurantService {

	private static final Logger logger = LogManager.getLogger(RestaurantService.class);
	
	@Autowired
	private RestaurantRepository repo;
	
	public Iterable<Restaurant> getRestaurants() {
		return repo.findAll();
	}
	public Restaurant createRestaurant(Restaurant restaurant) {
		return repo.save(restaurant);
	}
	
	public Restaurant updateRestaurant(Restaurant restaurant, Long id) throws Exception {
		try {
			Restaurant oldRestaurant = repo.findOne(id);
			oldRestaurant.setRestaurant_description(restaurant.getRestaurant_description());
			oldRestaurant.setRestaurant_name(restaurant.getRestaurant_name());
			return repo.save(oldRestaurant);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update restaurant: " + id, e);
			throw new Exception("Unable to update restaurant.");
		}
	}
	
	public void removeRestaurant(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete restaurant: " + id, e);
			throw new Exception("Unable to delete restaurant.");
		}
	}
}
