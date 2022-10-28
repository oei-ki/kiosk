package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.CategoryDao;
import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
		
	}

	@Override
	public List<Category> getCategory() {
		return categoryDao.getCategory();
	}

	@Override
	public Category getSubCategory(String cateName) {
		return categoryDao.getSubCategory(cateName);
	}

	@Override
	public int deleteCategory(Category category) {
		return categoryDao.deleteCategory(category);
	}

}