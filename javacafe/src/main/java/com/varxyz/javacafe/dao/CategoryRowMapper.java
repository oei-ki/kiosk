package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Category;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category(rs.getLong("cid"),
				rs.getString("cateType"),rs.getString("cateName"), 
				rs.getTimestamp("regDate"));
		return category;
	}

}