package com.niit.service;

import com.niit.model.Cart;

public interface CartService {
	
	Cart getCartByProductId(int CartId);
	
	 void update(Cart cart);

}
