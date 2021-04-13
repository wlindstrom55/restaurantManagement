package com.promineotech.restaurantManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.restaurantManagement.util.Rating;

@Entity
public class Review {

	private Long id;
	private Long restId; 
	private String reviewDescription;
	private Rating rating;

	@JsonIgnore
	private Restaurant restaurant;
	
	@JsonIgnore
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRestId() {
		return restId;
	}
	
	public void setRestId(Long restId) {
		this.restId = restId;
	}
	
	public String getReviewDescription() {
		return reviewDescription;
	}
	
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
//	public Long getUserId() {
//		return userId;
//	}
//	
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name = "restaurantId")
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
