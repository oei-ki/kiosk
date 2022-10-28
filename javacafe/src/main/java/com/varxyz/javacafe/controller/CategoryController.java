package com.varxyz.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.dao.CategoryCommand;
import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.CategoryServiceImpl;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	@GetMapping("/cafe/add_category")
	public String addCategoryForm(Model model, HttpServletRequest request) {
		model.addAttribute("category", new CategoryCommand());
		
		List<Category> categoryList = categoryService.getCategory();
		request.setAttribute("categoryList", categoryList);	
		
		return "cafe/category";
	}
	
	@ModelAttribute("cateTypeProvider")
	public List<String> getCateTypeProviderList() {
		List<String> list = new ArrayList<String>();
		list.add("커피");
		list.add("음료");
		list.add("디저트");
		
		return list;
	}
	
	@PostMapping("/cafe/add_category")
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		
		model.addAttribute("category",category);
		category.setCateType(category.getCateType());
		category.setCateName(category.getCateName());
		
		categoryService.addCategory(category);
		
		return "cafe/success_category";
	}
	

	/**
	 * 카테고리삭제
	 * bId통해 게시글 데이터를 받아 삭제함
	 * @param model
	 * @param request
	 * @param session
	 * @return 
	 * @return
	 * @throws Exception
	 */
	
	  @PostMapping("/cafe/delete") 
	  public String deleteForm(Model model,HttpServletRequest request) throws Exception {
		  
		  long cid =Integer.parseInt(request.getParameter("cid"));
	  		  
			Category category = new Category();
			category.setCid(cid);
		  
		  categoryService.deleteCategory(category);

		  return "redirect:add_category"; 
	  }
	  //input 값을 request를 통해서 cid값을 넘겨줌 
	  

}
