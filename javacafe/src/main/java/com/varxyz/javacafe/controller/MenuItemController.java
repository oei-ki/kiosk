package com.varxyz.javacafe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CategoryServiceImpl;
import com.varxyz.javacafe.service.MenuItemServiceImpl;

@Controller
public class MenuItemController {
	
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@Autowired
	CategoryServiceImpl categoryService;
	
//	@GetMapping
//	public String addMenuForm(Model model, HttpServletRequest request) {
//		model.addAttribute("menuItem", new MenuItemCommand());
//		List<Category> menuCategoryList = categoryService.getCategory();
//		request.setAttribute("menuCategoryList", menuCategoryList);	
//		
//		return "cafe/add_menu";
//	}
	
	   @GetMapping("/cafe/add_menu")
	   public String addMenuForm(Model model) {
	      model.addAttribute("menuItem", new MenuItemCommand());
	      model.addAttribute("category", categoryService.getCategory());
	      return "cafe/add_menu";
	   }
	
	@ModelAttribute("CategoryProviderList")//속성값 클래스에 넣고 리스트 다오에서 찾는 메서드 만들어서 컨트롤러에 넣어서 만들기...
	public List<Category> getCategoryProviderList() {
		List<Category> list = categoryService.getCategory();
		return list;  //팀장님이 해주신건데 일단 주석처리하고 list로 함 땡겨와보자 get안에 다 비워도 됨 이걸로 할 때 
	}
	/**
	 * 카테고리 추가한 db를 가져다가 옵션으로 나오게 만들고 싶음.
	 */
//	@PostMapping
//	public String addMenuItem(@ModelAttribute("menuItem") MenuItem menuItem, Model model) {
//		
//		model.addAttribute("menuItem", menuItem);
//		menuItem.setMenuName(menuItem.getMenuName());
//		menuItem.setMenuSize(menuItem.getMenuSize());
//		menuItem.setMenuPrice(menuItem.getMenuPrice());
//		menuItem.setImgUrl(menuItem.getImgUrl());
//		
//		
//		menuItemService.addMenuItem(menuItem);
//		
//		return "cafe/success_add_menu";
//	}
	   
	   
	    
	   /**
	    * 계속 cateFk 값 안맞다고 오류남...
	    */
	   @PostMapping("/cafe/add_menu")
	   public String addMenuItem(@ModelAttribute("menuItem")
	            MenuItemCommand menuItemcommand, Model model, HttpServletRequest request, @RequestParam("file") MultipartFile menuImgName) throws IllegalStateException, IOException {
	      
	      String filePath = "C:\\Users\\PC\\eclipse-workspace\\javacafe\\src\\main\\webapp\\resources\\img\\";
	      //파일명 C:\Users\PC\eclipse-workspace\javacafe\src\main\webapp\resources\img
	      String originalFile = menuImgName.getOriginalFilename();  //파일 이름을 String 값으로 반환한다
	      System.out.println(originalFile);
	      
	      //파일명 중 확장자만 추출
	      String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
	      
	      //저장된 파일 이름
	      String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      
	      File file = new File(filePath + storedFileName);
	      menuImgName.transferTo(file);
	      
	      model.addAttribute("menuItemCommand", menuItemcommand);
	      MenuItem menuItem = new MenuItem();
	      menuItem.setCateFk(menuItemcommand.getCateFk());
	      menuItem.setMenuName(menuItemcommand.getMenuName());
	      menuItem.setMenuPrice(menuItemcommand.getMenuPrice());
	      menuItem.setMenuSize(menuItemcommand.getMenuSize());
	      menuItem.setImgUrl(storedFileName);
	      menuItemService.addMenuItem(menuItem);
	      
	      String categoryName = menuItemService.getCategoryName(menuItemcommand.getCateFk());
	      
	      request.setAttribute("categoryName", categoryName);
	      
	      
	      return "cafe/success_add_menu";
	   }
	   
	   @GetMapping("/cafe/allmenu")
	   public String allMenuForm(Model model,HttpServletRequest request) {
			model.addAttribute("menuItem", new MenuItemCommand());
			
			List<MenuItem> menuList = menuItemService.getMenuItemList();
			request.setAttribute("menuList", menuList);	
	      return "cafe/success_add_menu";
	   }
	   
	   @PostMapping("/cafe/menudelete")
	   public String deleteForm(Model model,HttpServletRequest request) throws Exception {
		   long mid =Integer.parseInt(request.getParameter("mid"));
			
			MenuItem menuItem = new MenuItem();
			menuItem.setMid(mid);
		  
			menuItemService.DeleteMenu(menuItem);
	      return "redirect:allmenu";
	   }


}