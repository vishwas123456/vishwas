package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<Product> getAllProduct() {
		List<Product> allProduct=new ArrayList<Product>();
		Query q=sessionFactory.openSession().createQuery("from Product");
		allProduct=q.list();
		return allProduct;
	}
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		Product product=(Product) sessionFactory.openSession().get(Product.class, pid);
		 return product;
	}
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		sessionFactory.openSession().saveOrUpdate(product);
		System.out.println("sasda");
		return true;
		}
	public boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		
		Session session= sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
		return true;
	}
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.delete(product);
		session.flush();
		
		return true;
	}
}
