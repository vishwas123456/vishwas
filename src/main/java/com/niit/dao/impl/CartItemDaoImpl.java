package com.niit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		
	}

	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		
		Session session= sessionFactory.openSession();
		session.delete(cartItem);
		session.flush();
		
	}

	public void removeAllCartItems(Cart cart) {
		// TODO Auto-generated method stub
		
		List<CartItem> cartItem=cart.getCartItem();
		for(CartItem item : cartItem) {
			
		removeCartItem(item);	
		}
		
	}

	public CartItem getCartItemByProductId(int pid) {
		// TODO Auto-generated method stub
		
		Session session= sessionFactory.openSession();
		Query query= session.createQuery("from CartItem where pid=?");
		query.setInteger(0, pid);
		session.flush();
		return (CartItem) query.uniqueResult();
	}

}
