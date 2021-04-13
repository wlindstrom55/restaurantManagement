package com.promineotech.restaurantManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurantManagement.entity.Review;
import com.promineotech.restaurantManagement.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getReviews() {
		return new ResponseEntity<Object>(service.getReview(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createReview(@RequestBody Review review) {
		return new ResponseEntity<Object>(service.createReview(review), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateReview(@RequestBody Review review, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateReview(review, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update review ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteReview(@PathVariable Long id) {
		try {
			service.deleteReview(id);
			return new ResponseEntity<Object>("Successfully delete review with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete review ", HttpStatus.BAD_REQUEST);
		}
	}
}
