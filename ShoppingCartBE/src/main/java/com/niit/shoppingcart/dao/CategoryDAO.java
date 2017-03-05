package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.domain.Category;


public interface CategoryDAO 
{
	//Get All Categories
	public List<Category> getAllCategories();
	
	//Create Category
	public boolean createCategory(Category category);
	
	//Update Category
	public boolean updateCategory(Category category);
	
	//Delete Category by category
	public boolean delete(Category category);
	
	//Delete Category by id
	public boolean delete(String id);
	
	//Get Category By Id
	public Category getCategoryById(String id);
	
	//Get Category By Name
	public Category getCategoryByName(String name);
}
