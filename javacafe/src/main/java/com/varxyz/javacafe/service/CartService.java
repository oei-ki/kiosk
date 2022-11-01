package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Cart;

public interface CartService {
	
	public void addCart(Cart cart);
	public int DeleteCart(Cart cart);
	public List<Cart> getCart();
	public List<Cart> getAllCartToKiosk(long orderid);
	public List<Cart> getPayCart(long orderid);
}