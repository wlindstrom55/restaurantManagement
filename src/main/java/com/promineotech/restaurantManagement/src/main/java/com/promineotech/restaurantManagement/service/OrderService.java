package com.promineotech.restaurantManagement.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.restaurantManagement.entity.User;
import com.promineotech.restaurantManagement.entity.Order;
import com.promineotech.restaurantManagement.entity.Product;

import com.promineotech.restaurantManagement.repository.OrderRepository;
import com.promineotech.restaurantManagement.repository.ProductRepository;
import com.promineotech.restaurantManagement.service.OrderService;
import com.promineotech.restaurantManagement.util.Level;
import com.promineotech.restaurantManagement.util.OrderStatus;
import com.promineotech.restaurantManagement.repository.UserRepository;

@Service
public class OrderService {

	private static final Logger logger = LogManager.getLogger(OrderService.class);
	private final int DELIVERY_DAYS = 7;
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public Order submitNewOrder(Set<Long> productIds, Long userId) throws Exception {
		try {
			User user = userRepo.findOne(userId);
			Order order = initializeNewOrder(productIds, user);
			return repo.save(order);
		} catch (Exception e) {
			logger.error("Exception occurred while tring to create new order for user: " + userId, e);
			throw e;
		}
	}
	
	public Order cancelOrder(Long orderId) throws Exception {
		try {
			Order order = repo.findOne(orderId);
			order.setStatus(OrderStatus.CANCELLED);
			return repo.save(order);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to cancel order: " + orderId, e);
			throw new Exception("Unable to update order.");
		}
	}
	
	public Order completeOrder(Long orderId) throws Exception {
		try {
			Order order = repo.findOne(orderId);
			order.setStatus(OrderStatus.DELIVERED);
			order.setDelivered( LocalDate.now() ); //had to add this one in 
			return repo.save(order);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to complete order: " + orderId, e);
			throw new Exception("Unable to update order.");
		}
	}
	
	private Order initializeNewOrder(Set<Long> productIds, User user) {
		Order order = new Order();
		order.setProducts(convertToProductSet(productRepo.findAll(productIds)));
		order.setOrdered(LocalDate.now());
		order.setEstimatedDelivery(LocalDate.now().plusDays(DELIVERY_DAYS));
		order.setUser(user);
		order.setInvoiceAmount(calculateOrderTotal(order.getProducts(), user.getOrderlevel()));
		order.setStatus(OrderStatus.ORDERED);
//		addOrderToProducts(order);
		return order;
	}
	
	//gets the products, for each product, makes sure order is added to product.
	//makes the relationship fully symmetric
//	private void addOrderToProducts(Order order) {
//		Set<Product> products = order.getProducts();
//		for (Product product : products) {
//			product.getOrders().add(order);
//		}
//	}
	
	private Set<Product> convertToProductSet(Iterable<Product> iterable) {
		Set<Product> set = new HashSet<Product>();
		for (Product product : iterable) {
			set.add(product);
		}
		return set;
	}
	
	private double calculateOrderTotal(Set<Product> products, Level level) {
		double total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total - total * level.getDiscount();
	}
}
