package com.promineotech.restaurantManagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.restaurantManagement.entity.Reservation;
import com.promineotech.restaurantManagement.repository.ReservationRepository;

@Service
public class ReservationService {

		private static final Logger logger = LogManager.getLogger(ReservationService.class);
		
		@Autowired
		private ReservationRepository repo;
		
		public Reservation getReservationById(Long id) throws Exception {
			try {
				return repo.findOne(id);
			} catch (Exception e) {
				logger.error("Exception occurred while trying to retrieve reservation: " + id, e);
				throw e;
			}
		}
		
		public Iterable<Reservation> getReservations() {
			return repo.findAll();
		}
		
		public Reservation createReservation(Reservation reservation) {
			return repo.save(reservation);
		}
		
		public Reservation updateReservation(Reservation reservation, Long id) throws Exception {
			try {
				Reservation oldReservation = repo.findOne(id);
				oldReservation.setReservation_time(reservation.getReservation_time());
				oldReservation.setReservation_group(reservation.getReservation_group());
				return repo.save(oldReservation);
			} catch (Exception e) {
				logger.error("Exception occurred while trying to update reservation: " + id, e);
				throw new Exception("Unable to update reservation.");
			}
		}
		
		public void deleteReservation(Long id) throws Exception {
			try {
				repo.delete(id);
			} catch (Exception e) {
				logger.error("Exception occurred while trying to delete reservation: " + id, e);
				throw new Exception("Unable to delete reservation.");
			}
		}
		
}
