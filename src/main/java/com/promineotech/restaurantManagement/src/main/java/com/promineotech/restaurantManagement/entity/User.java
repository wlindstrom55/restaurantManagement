package com.promineotech.restaurantManagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.restaurantManagement.util.Level;


@Entity
@Table(name = "users")
public class User {

	private Long id;
	private String hash;
	private String userName;
	private String address;
	private Level orderlevel; //had to change these so they didnt match
	private Set<Order> orders;
	private Set<Review> reviews;
	
	@JsonIgnore
	private Set<Reservation> reservations;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(unique=true) //this annotation forces each username to be unique
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Level getOrderlevel() {
		return orderlevel;
	}

	public void setOrderlevel(Level orderlevel) {
		this.orderlevel = orderlevel;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	//TODO put the set of res in, made get/sets, changed below to fit table names
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_reservation",
		joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "resId", referencedColumnName = "id"))
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	//TODO added set of rev, made onetomany relationship w/ rev
	//what should mappedBy be? can it be the same as set of order?
	@OneToMany(mappedBy = "user")
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}

