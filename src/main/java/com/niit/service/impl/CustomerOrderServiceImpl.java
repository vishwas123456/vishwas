package com.niit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CustomerOrderDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
import com.niit.service.CartService;
import com.niit.service.CustomerOrderService;
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	@Autowired
	private CustomerOrderDao customerOrderDao;
	@Autowired
	private CartService cartService;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(int cartId) {
		// TODO Auto-generated method stub
		
		double grandTotal=0;
		Cart cart= cartService.getCartByProductId(cartId);
		List<CartItem> cartItems= cart.getCartItem();
		for (CartItem item: cartItems) {
			
			grandTotal+=item.getTotalPrice();
			
		}
		return grandTotal;
	}

}
