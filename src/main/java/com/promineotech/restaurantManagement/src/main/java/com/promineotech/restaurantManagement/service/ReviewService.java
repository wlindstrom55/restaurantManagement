package com.promineotech.restaurantManagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.restaurantManagement.entity.Review;
import com.promineotech.restaurantManagement.repository.ReviewRepository;

@Service
public class ReviewService {

private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private ReviewRepository repo;
	
	public Review getReviewById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve review: " +id, e);
			throw e;
		}
	}
	
	public Iterable<Review> getReview() {
		return repo.findAll();
	}
	
	public Review createReview(Review review) {
		return repo.save(review);
	}
	
	public Review updateReview(Review review, Long id) throws Exception {
		try {
			Review oldReview = repo.findOne(id);
			oldReview.setRest_id(review.getRest_id());
			oldReview.setReviewDescription(review.getReviewDescription());
			oldReview.setRating(review.getRating());
			return repo.save(oldReview);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update review: " + id, e);
			throw new Exception("Unable to update review");
		}
	}
	
	public void deleteReview(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete review: " + id, e);
			throw new Exception("Unable to delete review");
		}
	}
}
