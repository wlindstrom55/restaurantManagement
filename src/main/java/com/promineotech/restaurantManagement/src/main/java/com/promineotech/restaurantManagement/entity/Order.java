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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.restaurantManagement.util.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {

	private Long id;
	private LocalDate ordered;
	private LocalDate estimatedDelivery;
	private LocalDate delivered;
	private double invoiceAmount;
	private OrderStatus status; // may or may not need this depending on if we decide to implement (e.g.: delivered)
	private Set<Products> products;
	
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
	
	public LocalDate getOrdered() {
		return ordered;
	}
	
	public void setOrdered(LocalDate ordered) {
		this.ordered = ordered;
	}
	
	public LocalDate getEstimatedDelivery() {
		return estimatedDelivery;
	}
	
	public void setEstimatedDelivery(LocalDate estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}
	
	public LocalDate getDelivered() {
		return delivered;
	}
	
	public void setDelivered(LocalDate delivered) {
		this.delivered = delivered;
	}
	
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	@ManyToMany(mappedBy = "orders")
	public Set<Products> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
	@ManyToOne
	@JoinColumn(name = "rest_Id")
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
