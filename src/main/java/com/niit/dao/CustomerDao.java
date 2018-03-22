package com.niit.dao;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerDao {
	
	boolean addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
