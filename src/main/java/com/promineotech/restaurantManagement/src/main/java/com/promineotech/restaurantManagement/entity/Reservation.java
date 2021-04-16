package com.promineotech.restaurantManagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.restaurantManagement.util.ReservationStatus;

@Entity
public class Reservation {

		private Long id;
		private int reservation_size;
		private ReservationStatus status;
		
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private String reservation_time; 
		
		private User user;
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
		public String getReservation_time() {
			return reservation_time;
		}
		public void setReservation_time(String reservation_time) {
			this.reservation_time = reservation_time;
		}
		
		//TODO gave this many to many annotation. Not sure about mappedBy
		//Changed to OneToMany for better functionality approved with Jeff who will be grading our finals 
		@OneToMany(mappedBy = "reservations")
		public User user() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		//TODO added many to one. 
		@ManyToOne
		@JoinColumn(name = "restaurant")
		public Restaurant getRestaurant() {
			return restaurant;
		}
		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
	
		public int getReservation_size() {
			return reservation_size;
		}
		public void setReservation_size(int reservation_size) {
			this.reservation_size = reservation_size;
		}
		public ReservationStatus getStatus() {
			return status;
		}
		public void setStatus(ReservationStatus status) {
			this.status = status;
		}
		
		
}
