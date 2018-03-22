package com.niit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CustomerDao;
import com.niit.model.Authorities;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.Users;
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerid(customer.getCutomerId());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    
		return true;
	}

	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		return (Customer)session.get(Customer.class, customerId);
		
		
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer");
		List<Customer> customerList=query.list();
		return customerList;
	}

	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query= session.createQuery("from Customer where username=?");
		query.setString(0, username);
		session.flush();
		return (Customer) query.uniqueResult();
		
		/*Customer cust=(Customer) sessionFactory.openSession().get(Customer.class, username);
		return cust;*/
	}
	
	

}
