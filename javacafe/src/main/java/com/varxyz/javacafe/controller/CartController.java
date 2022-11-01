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

import com.varxyz.javacafe.dao.CategoryCommand;
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
		   
		  long oid = Cart.orderNum - 1;
		  System.out.println(oid);

		 //sevice호출 할 객체 생성 및 값 입력
		  // orderid를 가져오는 dao를 만들어야함 
		  List<Cart> cartList = cartService.getPayCart(oid);
		  request.setAttribute("orderid", oid);
		  request.setAttribute("cartList", cartList);
			/*
			 * List<Cart> cartList = cartService.getCart(); request.setAttribute("cartList",
			 * cartList);
			 */
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
		 
		  
		  return "redirect:pay"; 
		  //redirect -> 사용된 페이지에 한번더 값을 전달해줘서 로딩해야할 때 
		  //껏다 켰을때 카드비우기 만들기 init?? 처음에 자동실행되게 만들기
	   }
}
