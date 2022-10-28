package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public interface CategoryService {
 
	public void addCategory(Category category);
	List<Category> getCategory();
	public Category getSubCategory(String cateName);
	public int deleteCategory(Category category);
}