package com.promineotech.restaurantManagement.entity;

import javax.persistence.Entity;

import com.promineotech.restaurantManagement.util.Rating;

@Entity
public class Review {

	private Long id;
	private Long restId;
	private Long userId;
	private String reviewDescription;
	private Rating rating;
	
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
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
