package com.promineotech.restaurantManagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.restaurantManagement.entity.Product;
import com.promineotech.restaurantManagement.repository.ProductRepository;

@Service
public class ProductService {

		private static final Logger logger = LogManager.getLogger(ProductService.class);
		
		@Autowired
		private ProductRepository repo;
		
		public Iterable<Product> getProducts() {
			return repo.findAll();
		}
		public Product createProduct(Product product) {
			return repo.save(product);
		}
		
		public Product updateProduct(Product product, Long id) throws Exception {
			try {
				Product oldProduct = repo.findOne(id);
				oldProduct.setDescription(product.getDescription());
				oldProduct.setProduct_name(product.getProduct_name());
				oldProduct.setPrice(product.getPrice());
				return repo.save(oldProduct);
			} catch (Exception e) {
				logger.error("Exception occurred while trying to update product: " + id, e);
				throw new Exception("Unable to update product.");
			}
		}
		
		public void removeProduct(Long id) throws Exception {
			try {
				repo.delete(id);
			} catch (Exception e) {
				logger.error("Exception occurred while trying to delete product: " + id, e);
				throw new Exception("Unable to delete product.");
			}
		}
}
