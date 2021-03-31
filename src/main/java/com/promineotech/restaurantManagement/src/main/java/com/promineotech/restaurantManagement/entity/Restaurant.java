package com.promineotech.restaurantManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
		
	private Long id;
	private String restaurant_name;
	private String restaurant_description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_description() {
		return restaurant_description;
	}
	public void setRestaurant_description(String restaurant_description) {
		this.restaurant_description = restaurant_description;
	}
	

}
