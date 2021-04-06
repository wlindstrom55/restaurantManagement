package com.promineotech.restaurantManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurantManagement.entity.Restaurant;
import com.promineotech.restaurantManagement.service.RestaurantService;
	
	@RestController
	@RequestMapping("/restaurants")
	public class RestaurantController {

			@Autowired
			private RestaurantService service;
			
			@RequestMapping(method=RequestMethod.GET)
			public ResponseEntity<Object> getRestaurants() {
				return new ResponseEntity<Object>(service.getRestaurants(), HttpStatus.OK);
			}
			
			@RequestMapping(method=RequestMethod.POST)
			public ResponseEntity<Object> createRestaurant(@RequestBody Restaurant restaurant) {
				return new ResponseEntity<Object>(service.createRestaurant(restaurant), HttpStatus.CREATED);
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.PUT)
			public ResponseEntity<Object> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Long id) {
				try {
					return new ResponseEntity<Object>(service.updateRestaurant(restaurant, id), HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<Object>("Unable to update restaurant details.", HttpStatus.BAD_REQUEST);
				}
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
			public ResponseEntity<Object> deleteRestaurant(@PathVariable Long id) {
				try {
					service.removeRestaurant(id);
					return new ResponseEntity<Object>("Successfully deleted restaurant with id: " + id, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<Object>("Unable to delete restaurant.", HttpStatus.BAD_REQUEST);
				}
			}
	}
