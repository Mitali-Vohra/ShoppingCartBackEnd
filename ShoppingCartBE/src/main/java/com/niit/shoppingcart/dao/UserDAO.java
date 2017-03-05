package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {

	public List<User> getAllUsers();
	
	public User getUserById(String userId);
	
	public User getUserByName(String name);
	
	public boolean updateUser(User user);
	
	public boolean deleteUserById(String userId);
	
	public boolean deleteUser(User user);
	
	public boolean addUsers(User user);
}
