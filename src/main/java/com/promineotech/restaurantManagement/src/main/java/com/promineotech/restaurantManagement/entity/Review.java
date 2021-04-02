package com.promineotech.restaurantManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.promineotech.restaurantManagement.util.Rating;

@Entity
public class Review {

	private Long id;
	private Long rest_Id;
	private Long user_Id;
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
	
	public Long getRest_Id() {
		return rest_Id;
	}
	
	public void setRest_Id(Long rest_Id) {
		this.rest_Id = rest_Id;
	}
	
	public String getReviewDescription() {
		return reviewDescription;
	}
	
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
	public Long getUser_Id() {
		return user_Id;
	}
	
	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
