package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public interface MenuItemService {

	public void addMenuItem(MenuItem menuItem);
	public List<MenuItem> getMenuItemList();
	public String getCategoryName(long cateFk);
	public MenuItem getMenuItemBymenuName(String menuName);
	public List<MenuItem> getAllMenuToKiosk(long cateFk);
	public int DeleteMenu(MenuItem menuItem);
	public List<MenuItem> getMenuItemCart();
	public List<MenuItem> inCartList(long mid);
}