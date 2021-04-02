package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.promineotech.restaurantManagement.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
