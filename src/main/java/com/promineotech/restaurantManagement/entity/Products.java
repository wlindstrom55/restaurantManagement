package com.promineotech.restaurantManagement.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Products {

	private Long id;
	private String product_name;
	private Long rest_id;
	private Long price;
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rest_id")
	public Long getRest_id() {
		return rest_id;
	}

	public void setRest_id(Long rest_id) {
		this.rest_id = rest_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
