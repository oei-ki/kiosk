package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.CartDao;
import com.varxyz.javacafe.domain.Cart;

public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;

	@Override
	public void addCart(Cart cart) {
		cartDao.addCart(cart);
	}

	@Override
	public int DeleteCart(Cart cart) {
		return cartDao.DeleteCart(cart);
	}

	@Override
	public List<Cart> getCart() {
		return cartDao.getCart();
	}

	@Override
	public List<Cart> getAllCartToKiosk(long orderid) {
		return cartDao.getAllCartToKiosk(orderid);
	}

	@Override
	public List<Cart> getPayCart(long orderid) {
		return cartDao.getPayCart(orderid);
	}


}