package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
	private static User user;
	
	@Autowired 
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
//		@Test
		public void createUserTestCase() 
		{
			user.setUserId("1");
			user.setEmailId("nikhilvohra96@gmail.com");
			user.setName("Nikhil");
			user.setPassword("nikhil001");
			user.setContact("9874999999");
			
			
	
			boolean flag = userDAO.addUsers(user);
	
			Assert.assertEquals("createUserTestCase", true, flag);
		}
//		
//		@Test
//		public void updateUserTestCase()
//		{
//			user.setUserId("1");
//			user.setEmailId("metalivohra94@gmail.com");
//			user.setName("Metali");
//			user.setPassword("kumar111");
//			user.setContact("98746734790");
//			
//			boolean flag = userDAO.updateUser(user);
//			
//			Assert.assertEquals("createUserTestCase", true, flag);
//
//		}

//		@Test
//		public void delteUserByIdTestCase()
//		{
//	
//			boolean flag = userDAO.deleteUserById("1");
//		
//			Assert.assertEquals("delteUserByIdTestCase", true, flag);
//
//		}
	
		@Test
		public void deleteUserTestCase()
		{
			user.setUserId("1");
			user.setEmailId("metalivohra94@gmail.com");
			user.setName("Metali");
			user.setPassword("kumar111");
			user.setContact("98746734790");	
			
		
			boolean flag = userDAO.deleteUser(user);
		
			Assert.assertEquals("deleteUserTestCase", true, flag);

		}
	
//		@Test
//		public void getAllUserTestCase()
//		{
//			int recordsFromDao = userDAO.getAllUsers().size();
//			
//			Assert.assertEquals("getAllUserTestCase", 1, recordsFromDao);
//		}
//
//		@Test
//		public void getUserByIdTestCase()
//		{
//			user = userDAO.getUserById("nikhilvohra96@gmail.com");
//			
//			Assert.assertNotNull(user);
//		}
	
//		@Test
//		public void getUserByNameTestCase()
//		{
//			user = userDAO.getUserByName("Nikhil");
//			
//			Assert.assertNotNull(user);
//		}
		
}
