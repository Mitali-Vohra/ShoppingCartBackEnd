package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> getAllSuppliers();
	
	public boolean addSupplier(Supplier supplier);
	
	public boolean updateSupplier(Supplier supplier);
	
	public boolean deleteSupplierById(String id);
	
	public boolean deleteSupplier(Supplier supplier);
	
	public Supplier getSupplierById(String id);
	
	public Supplier getSupplierByName(String name);
	
	
}
