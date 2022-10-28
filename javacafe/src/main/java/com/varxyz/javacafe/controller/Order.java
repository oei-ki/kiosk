package com.varxyz.javacafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cafe/order")
public class Order {
	
	@GetMapping
	public String orderForm(Model model, HttpServletRequest request) {	
		
		return "main/order";
	}

}
