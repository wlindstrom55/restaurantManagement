package com.promineotech.restaurantManagement.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
		
	private Long id;
	private String restaurant_name;
	private String restaurant_description;
	private Set<Reservation> restaurant_res;
	private Set<Product> restaurant_menu;
	private Set<Review> restaurant_review;
	
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
	
	//TODO added set of reservation, added annotation to gets/sets
	@OneToMany(mappedBy = "restaurant")
	public Set<Reservation> getRestaurant_res() {
		return restaurant_res;
	}
	public void setRestaurant_res(Set<Reservation> restaurant_res) {
		this.restaurant_res = restaurant_res;
	}
	//TODO should it be same name or not?
	@OneToMany(mappedBy = "restaurant")
	public Set<Product> getRestaurant_menu() {
		return restaurant_menu;
	}
	public void setRestaurant_menu(Set<Product> restaurant_menu) {
		this.restaurant_menu = restaurant_menu;
	}
	//TODO
	@OneToMany(mappedBy = "restaurant")
	public Set<Review> getRestaurant_review() {
		return restaurant_review;
	}
	public void setRestaurant_review(Set<Review> restaurant_review) {
		this.restaurant_review = restaurant_review;
	}
	

}
