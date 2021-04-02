package com.promineotech.restaurantManagement.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.promineotech.restaurantManagement.util.Level;

@Entity
public class User {

	private Long id;
	private String userName;
	private Level level;
	private Set<Order> orders;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
