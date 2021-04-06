package com.promineotech.restaurantManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.restaurantManagement.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
