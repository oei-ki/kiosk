package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemRowMapper implements RowMapper<MenuItem>{

	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItem menuItem = new MenuItem();
		menuItem.setMid(rs.getLong("mid"));
		menuItem.setCateFk(rs.getLong("cateFk"));
		menuItem.setMenuName(rs.getString("menuName"));
		menuItem.setMenuSize(rs.getString("MenuSize"));
		menuItem.setMenuPrice(rs.getDouble("MenuPrice"));
		menuItem.setImgUrl(rs.getString("imgUrl"));
		menuItem.setRegDate(rs.getDate("regDate"));
		
		return menuItem;
	}
	
	
}