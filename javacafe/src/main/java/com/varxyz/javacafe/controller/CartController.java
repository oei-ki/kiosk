package com.varxyz.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.CartArgument;
import com.varxyz.javacafe.domain.CartList;
import com.varxyz.javacafe.service.CartServiceImpl;

@Controller
public class CartController {
	
	@Autowired
	CartServiceImpl cartService;
	
	   @GetMapping("/cafe/cart")
	   public String addMenuForm(Model model) {
	      model.addAttribute("cart", cartService.getCart());
	      return "main/mainpage";
	   }
	   
	   @GetMapping("/cafe/pay")
	   public String CartModalForm(Model model, HttpServletRequest request) {

			
	      return "main/pay";
	   }

	  @PostMapping("/cafe/pay") 
	  public String cartForm(@ModelAttribute(value="CartList") CartList cartList, Cart cart, Model model, HttpServletRequest request) {
	  

		  ArrayList<CartArgument> carts = cartList.getCartList();
		  int cartSize = carts.size();
		  for (int i = 0; i < cartSize; i++) {
			  model.addAttribute("cart",  cart);
			  cart.setOrderid(Cart.orderNum);
			  cart.setMenuName(carts.get(i).getMenuName());
			  cart.setNumber(carts.get(i).getNumber());
			  cart.setMenuPrice(carts.get(i).getMenuPrice());
		      cartService.addCart(cart);
		  }
		  Cart.orderNum += 1;
		  
		   long orderid = Integer.parseInt(request.getParameter("orderid"));
		   
		   Cart cart1 = new Cart();
		   cart1.setOrderid(orderid);
		   System.out.println(orderid);
	        
			List<Cart> cartList1 = cartService.getPayCart(orderid);
			request.setAttribute("cartList1", cartList1);
			System.out.println(cartList1);
		  
		  return "main/pay"; 
		  
	   }
	 
	
	
	/*
	 * @PostMapping("/cafe/deleteCart") public String deleteCartForm(Model
	 * model,HttpServletRequest request) throws Exception {
	 * 
	 * long caid =Integer.parseInt(request.getParameter("caid"));
	 * 
	 * Cart cart = new Cart(); cart.setCaid(caid);
	 * 
	 * cartService.DeleteCart(cart);
	 * 
	 * return "redirect:add_category"; }
	 */
	//input 값을 request를 통해서 cid값을 넘겨줌 
}
