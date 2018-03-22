package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductSevice {
	public List<Product> getAllProduct();
	
	Product getProductById(int pid);
	
	boolean addProduct(Product product);
	
	boolean editProduct(Product product);

	boolean deleteProduct(Product product);

}
