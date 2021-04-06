package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.restaurantManagement.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
