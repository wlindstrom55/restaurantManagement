package com.promineotech.restaurantManagement.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private OrderStatus status;
	private Set<Product> product;
	
	@JsonIgnore
	private User user;
	
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

	//TODO changed this to one to many. (1 order, many products).
	@OneToMany(mappedBy = "orders")
	public Set<Product> getProducts() {
		return product;
	}
	
	public void setProducts(Set<Product> products) {
		this.product = products;
	}
	
	@ManyToOne
	@JoinColumn(name = "user")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
