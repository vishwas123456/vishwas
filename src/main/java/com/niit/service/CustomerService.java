package com.niit.service;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerService {
	boolean addCustomer(Customer customer); 
	
	Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);


}
