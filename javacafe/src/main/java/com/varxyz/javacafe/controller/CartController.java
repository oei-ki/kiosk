package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.service.CartServiceImpl;

public class CartController {
	
	@Autowired
	CartServiceImpl cartService;

	
	  @PostMapping("/cafe/deleteCart") 
	  public String deleteCartForm(Model model,HttpServletRequest request) throws Exception {
		  
		  long caid =Integer.parseInt(request.getParameter("caid"));
	  		  
			Cart cart = new Cart();
			cart.setCaid(caid);
		  
			cartService.DeleteCart(cart);

		  return "redirect:add_category"; 
	  }
	//input 값을 request를 통해서 cid값을 넘겨줌 
}
