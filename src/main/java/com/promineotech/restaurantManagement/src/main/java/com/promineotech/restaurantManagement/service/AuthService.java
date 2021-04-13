package com.promineotech.restaurantManagement.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.promineotech.restaurantManagement.entity.Credentials;
import com.promineotech.restaurantManagement.entity.User;
import com.promineotech.restaurantManagement.repository.UserRepository;

@Service
public class AuthService {
		
		@Autowired
		private UserRepository userRepository;
		
		//creates a user, takes their password, adds a salt, hashes it, saves to repo, 
		public User register(Credentials cred) throws AuthenticationException {
			User user = new User();
			user.setUserName(cred.getUsername());
			user.setHash((BCrypt.hashpw(cred.getPassword(), BCrypt.gensalt())));
			try {
			userRepository.save(user);
			return user;
			} catch (DataIntegrityViolationException e) {
				throw new AuthenticationException("Username not available.");
			}
		}
		
		public User login(Credentials cred) throws AuthenticationException {
			User foundUser = userRepository.findByuserName(cred.getUsername());
			if (foundUser != null && BCrypt.checkpw(cred.getPassword(), foundUser.getHash())) { //nullcheck comes first, then check to see if pw matches. Otherwise we get null pointer exception
				return foundUser;
			}
			throw new AuthenticationException("Incorrect username or password");
		}
		
}
