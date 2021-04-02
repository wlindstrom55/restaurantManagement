package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.promineotech.restaurantManagement.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
