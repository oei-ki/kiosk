package com.varxyz.javacafe.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CartService;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.CategoryServiceImpl;
import com.varxyz.javacafe.service.MenuItemServiceImpl;

@Controller
public class MenuItemFindController {

	@Autowired
	MenuItemServiceImpl menuItemService;

	@Autowired
	CategoryServiceImpl categoryService;

	@Autowired
	CartServiceImpl cartService;

//	@GetMapping
//	public String findMenuItemForm(Model model) {
//      model.addAttribute("menuItem", new MenuItemCommand());
//      model.addAttribute("category", categoryService.getCategory());
//     
//      return "main/mainpage";
//	}

	@GetMapping("/cafe/main")
	public String findMenuItemForm(Model model, HttpServletRequest request) {
		model.addAttribute("menuItem", new MenuItemCommand());

		List<MenuItem> menuList = menuItemService.getMenuItemList();
		request.setAttribute("menuList", menuList);

		List<Category> categoryList = categoryService.getCategory();
		request.setAttribute("categoryList", categoryList);
		
		List<Cart> cartList = cartService.getCart();
		request.setAttribute("cartList", cartList);

		return "main/mainpage";
	}

//@Responsebody 어노테이션을 사용하면 http요청 body를 자바 객체로 전달받을 수 있다.
	@RequestMapping(value = "/cafe/requestObject", method = { RequestMethod.POST })
	@ResponseBody
	public List<MenuItem> getMenuItem(@RequestBody MenuItemCommand menuItemCommand,Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		List<MenuItem> menuList = menuItemService.getAllMenuToKiosk(menuItemCommand.getCateFk());
		return menuList;
	}

	/**
	 *ajax통해서 리스트에 집어넣는 거
	 * @param menuItemCommand
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cafe/requestCart", method = { RequestMethod.POST })
	@ResponseBody
	public List<MenuItem> getMenuCart(@RequestBody MenuItemCommand menuItemCommand,Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
			
		List<MenuItem> cartMenuList = menuItemService.inCartList(menuItemCommand.getMid());
		
		return cartMenuList;
	}

	
	/*
	 * model.addAttribute("cartCommand", cartCommand); Cart cart = new Cart();
	 * cart.setOrderid(cartCommand.getOrderid());
	 * cart.setMenuName(cartCommand.getMenuName());
	 * cart.setNumber(cartCommand.getNumber());
	 * cart.setMenuPrice(cartCommand.getMenuPrice()); cartService.addCart(cart);
	 */
	
//	@ModelAttribute("MenuItemProviderList")
//	public List<MenuItem> getMenuItemProviderList() {
//		List<MenuItem> list = menuItemService.getMenuItemList();
//		return list;
//	}

	/*
	 * @RequestMapping(value = "/cafe/requestForModal", method = {
	 * RequestMethod.POST })
	 * 
	 * @ResponseBody public MenuItem getMenuItemForModal(@RequestBody
	 * MenuItemCommand menuItemCommand, HttpServletRequest request) throws
	 * UnsupportedEncodingException { MenuItem menuItem =
	 * menuItemService.getMenuItemBymenuName(menuItemCommand.getImgUrl()); return
	 * menuItem; }
	 * 
	 * 
	 * @PostMapping("/cafe/main") public String inCart(Cart cart, HttpServletRequest
	 * request) { cartService.addCart(cart); return "redirect:main/mainpage"; }
	 */
	 

}