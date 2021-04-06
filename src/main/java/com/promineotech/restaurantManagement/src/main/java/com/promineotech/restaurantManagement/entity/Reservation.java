package com.promineotech.restaurantManagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Reservation {

		private Long id;
		private LocalDate reservation_time; //LocalDate only represents a date. Will still need localdateattributeconverter. 
		//try to find a way to use LocalDateTime, which has time/date
		private int reservation_size; //maybe incorporate some kind of list of possible users instead of this simple int
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getReservation_time() {
			return reservation_time;
		}
		public void setReservation_time(LocalDate reservation_time) {
			this.reservation_time = reservation_time;
		}
		public int getReservation_size() {
			return reservation_size;
		}
		public void setReservation_size(int reservation_size) {
			this.reservation_size = reservation_size;
		}
		
}
