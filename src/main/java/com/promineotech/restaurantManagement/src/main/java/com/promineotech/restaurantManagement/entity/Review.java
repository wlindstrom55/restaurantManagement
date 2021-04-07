package com.promineotech.restaurantManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.promineotech.restaurantManagement.util.Rating;

@Entity
public class Review {

	private Long id;
	private Long rest_id;
	private Long user_id;
	private String reviewDescription;
	private Rating rating;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRest_id() {
		return rest_id;
	}
	
	public void setRest_id(Long rest_id) {
		this.rest_id = rest_id;
	}
	
	public String getReviewDescription() {
		return reviewDescription;
	}
	
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
