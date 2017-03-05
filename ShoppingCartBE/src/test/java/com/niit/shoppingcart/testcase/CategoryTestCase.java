
package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	// TEST CASES
	@SuppressWarnings("deprecation")
	@Test
	public void createCategoryTestCase() 
	{
		category.setId("1");
		category.setName("Mobile Category");
		category.setDescription("This is Mobile Category");
		
		

		boolean flag = categoryDAO.createCategory(category);

		Assert.assertEquals("createCategoryTestCase", true, flag);
	}
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void updateCategoryTestCase()
//	{
//		category.setId("1");
//		category.setName("Mobile Category");
//		category.setDescription("This is Mobile Category");
//		
//		boolean flag = categoryDAO.updateCategory(category);
//		
//		Assert.assertEquals("updateCategoryTestCase", true, flag);
//				
//	}
	
//	@Test
//	public void deleteCategoryByIdTestCase()
//	{	
//		boolean flag = categoryDAO.delete("1");
//		
//		Assert.assertEquals("deleteCategoryTestCase",true,flag);
//	}
	
//	@Test
//	public void deleteCategoryTestCase()
//	{
//		category.setId("2");
//		category.setName("Laptop Category");
//		category.setDescription("This is laptop category");
//		
//		boolean flag = categoryDAO.delete(category);
//		
//		Assert.assertEquals("deleteCategoryTestCase",true,flag);
//	}
	
//	@Test
//	public void getCategoryByIdTestCase()
//	{
//		category = categoryDAO.getCategoryById("1");
//		
//		Assert.assertNotNull(category);
//	}
	

//	@Test
//	public void getCategoryByNameTestCase()
//	{
//		category = categoryDAO.getCategoryByName("Mobile Category");
//		
//		Assert.assertNotNull(category);
//	}

//	@Test
//	public void getAllCategoryTestCase()
//	{
//		int recordsFromDao = categoryDAO.getAllCategories().size();
//		
//		Assert.assertEquals("getAllCategoryTestCase", 3, recordsFromDao);
//	}

}
