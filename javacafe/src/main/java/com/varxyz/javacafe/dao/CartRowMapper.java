package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public class CartRowMapper implements RowMapper<Cart>{

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setCaid(rs.getLong("mid"));
		cart.setOrderid(rs.getLong("cateFk"));
		cart.setMenuName(rs.getString("menuName"));
		cart.setNumber(rs.getInt("MenuSize"));
		cart.setMenuPrice(rs.getDouble("MenuPrice"));
		cart.setRegDate(rs.getDate("regDate"));
		
		return cart;
	}
}