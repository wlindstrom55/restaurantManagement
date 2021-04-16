package com.promineotech.restaurantManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurantManagement.entity.Reservation;
import com.promineotech.restaurantManagement.service.ReservationService;

@RestController
@RequestMapping("users/{id}/reservations")
public class ReservationController {

		@Autowired
		private ReservationService service;
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<Object> getReservations() {
			return new ResponseEntity<Object>(service.getReservations(), HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
			return new ResponseEntity<Object>(service.createReservation(reservation), HttpStatus.CREATED);
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Object> updateReservation(@RequestBody Reservation reservation, @PathVariable Long id) {
			try {
				return new ResponseEntity<Object>(service.updateReservation(reservation, id), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>("Unable to update reservation details.", HttpStatus.BAD_REQUEST);
			}
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Object> deleteReservation(@PathVariable Long id) {
			try {
				service.deleteReservation(id);
				return new ResponseEntity<Object>("Successfully deleted reservation with id: " + id, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>("Unable to delete reservation.", HttpStatus.BAD_REQUEST);
			}
		}
}

