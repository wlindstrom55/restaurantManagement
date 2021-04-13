package com.promineotech.restaurantManagement.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {

		private Long id;
		private LocalDate reservation_time; //LocalDate only represents a date. Will still need localdateattributeconverter. 
		//try to find a way to use LocalDateTime, which has time/date
		private Set<User> reservation_group;
		
		@JsonIgnore
		private Restaurant restaurant;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
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
		
		//TODO gave this many to many annotation. Not sure about mappedBy
		@ManyToMany(mappedBy = "reservations")
		public Set<User> getReservation_group() {
			return reservation_group;
		}
		public void setReservation_group(Set<User> reservation_group) {
			this.reservation_group = reservation_group;
		}
		//TODO added many to one. 
		@ManyToOne
		@JoinColumn(name = "restaurantId")
		public Restaurant getRestaurant() {
			return restaurant;
		}
		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
		 
}
