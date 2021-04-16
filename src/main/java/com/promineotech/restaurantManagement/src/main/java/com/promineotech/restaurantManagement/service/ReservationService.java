package com.promineotech.restaurantManagement.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.restaurantManagement.entity.Reservation;
import com.promineotech.restaurantManagement.entity.User;
import com.promineotech.restaurantManagement.repository.ReservationRepository;
import com.promineotech.restaurantManagement.repository.RestaurantRepository;
import com.promineotech.restaurantManagement.repository.UserRepository;
import com.promineotech.restaurantManagement.util.ReservationStatus;


@Service
public class ReservationService {
		private static final Logger logger = LogManager.getLogger(ReservationService.class);
		
		@Autowired
		private ReservationRepository resRepo;
		@Autowired
		private UserRepository userRepo;
		@Autowired
		private RestaurantRepository restRepo;
		
		
		public Iterable<Reservation> getReservations() {
		return resRepo.findAll();
	}
	
	public Reservation createReservation(Reservation reservation) {
		try {
			Reservation res = initializeReservation(reservation);
		return resRepo.save(res);
		} catch (Exception e) {
			logger.error("Exception occurred while creating reservation: " , e);
			throw e;
		}

	}	
	
	private Reservation initializeReservation(Reservation reservation) {
			Reservation reserv = new Reservation();
			reserv.setReservation_size(reservation.getReservation_size());
			reserv.setReservation_time(reservation.getReservation_time());
			reserv.setStatus(ReservationStatus.SUBMITTED);
			return reserv;
		
	}
	public Reservation updateReservation(Reservation reservation, Long id) throws Exception {
		try {
			Reservation oldReservation = resRepo.findOne(id);
			oldReservation.setReservation_time(reservation.getReservation_time());
			oldReservation.setReservation_size(reservation.getReservation_size());
			oldReservation.setStatus(ReservationStatus.SUBMITTED);
			return resRepo.save(oldReservation);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update reservation: " + id, e);
			throw new Exception("Unable to update reservation.");
		}
	}
	
	public void deleteReservation(Long id) throws Exception {
		try {
			resRepo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete reservation: " + id, e);
			throw new Exception("Unable to delete reservation.");
		}
	}
	
}
