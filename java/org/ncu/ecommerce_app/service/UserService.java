package org.ncu.ecommerce_app.service;

import java.util.List;

import org.ncu.ecommerce_app.entity.User;


public interface UserService {
	 List<User> getAllUsers();
	    User getUserById(Long id);
	    User createUser(User user);
	    User updateUser(Long id, User user);
	    void deleteUser(Long id);
		User registerUser(User user);
		User loginUser(String username, String password);
}
