package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;



public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

	}

	// TEST CASES
	@SuppressWarnings("deprecation")
	@Test
	public void createSupplierTestCase() 
	{
		supplier.setId("1");
		supplier.setName("Mitali");
		supplier.setAddress("Faridabad");
		
		boolean flag = supplierDAO.addSupplier(supplier);
		

		Assert.assertEquals("createSupplierTestCase", true, flag);
	}
	
//	@Test
//	public void updateSupplierTestCase()
//	{
//		supplier.setId("1");
//		supplier.setName("Mehak");
//		supplier.setAddress("Faridabad");
//		
//		boolean flag = supplierDAO.updateSupplier(supplier);
//		
//		Assert.assertEquals("updateSupplierTestCase",true,flag);
//	}
	
//	@Test
//	public void getAllSuppliersTestCase()
//	{
//		int recordsFromDAO = supplierDAO.getAllSuppliers().size();
//		
//		Assert.assertEquals("getAllSuppliersTestCase",1,recordsFromDAO);
//	}
	
//	@Test
//	public void getSupplierByIdTestCase()
//	{
//		supplier = supplierDAO.getSupplierById("1");
//		
//		Assert.assertNotNull(supplier);
//	}
//	
//	@Test
//	public void getSupplierByNameTestCase()
//	{
//		supplier = supplierDAO.getSupplierByName("Mehak");
//		
//		Assert.assertNotNull(supplier);
//	}
//	
//	@Test
//	public void deleteSupplierByIdTestCase()
//	{
//		boolean flag =supplierDAO.deleteSupplierById("1");
//		
//		Assert.assertEquals("deleteSupplierByIdTestCase",true,flag);
//	}
	
//	@Test
//	public void deleteSupplierTestCase()
//	{
//		supplier.setId("1");
//		supplier.setName("Mitali");
//		supplier.setAddress("Faridabad");
//		
//		boolean flag = supplierDAO.deleteSupplier(supplier);
//		
//		Assert.assertEquals("deleteSupplierTestCase",true,flag);
//	}
}
