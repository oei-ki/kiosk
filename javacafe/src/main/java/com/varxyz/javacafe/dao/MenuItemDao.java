package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void addMenuItem(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (cateFk, menuName, menuSize, menuPrice, imgUrl)"
				+ " VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql,menuItem.getCateFk() ,menuItem.getMenuName(), menuItem.getMenuSize(),
				menuItem.getMenuPrice(), menuItem.getImgUrl());
	}	
	
//	public List<MenuItem> getMenuItem() {
//		String sql= "SELECT cateType, cateName, regDate, menuName, menuSize, ,menuPrice, imgUrl, regDate FROM MenuItem";
//		return jdbcTemplate.query(sql, new MenuItemRowMapper());
//	}
	
	public List<MenuItem> getMenuItemList() {
		String sql="SELECT mid, cateFk, menuName, menuSize, menuPrice, imgUrl, regDate FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
	public String getCategoryName(long cateFk) {
	      String sql = "SELECT cateName FROM Category WHERE cid = ?";
	      return jdbcTemplate.queryForObject(sql, String.class, cateFk);
	            
	}
	
	public MenuItem getMenuItemBymenuName(String menuName) {
		String sql = "SELECT * FROM MenuItem WHERE imgUrl=?";
		return jdbcTemplate.queryForObject(sql, new MenuItemRowMapper(), menuName);
	}
	
	/**
	 * 메뉴랑 카테고리 테이블 연결시킴
	 * ajax사용
	 * 카테고리명사용해서 조회가능하게 하는sql문인데...
	 * @param cateFk
	 * @return
	 */
	public List<MenuItem> getAllMenuToKiosk(long cateFk){
		String sql = "SELECT m.mid, m.cateFk, m.menuName, m.menuSize, m.menuPrice, m.imgUrl, l.cid, l.cateType, l.cateName"
				+ " FROM MenuItem m INNER JOIN Category l ON m.cateFk = l.cid WHERE m.cateFk=?";
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem();
				menuItem.setMid(rs.getLong("mid"));
				menuItem.setCateFk(rs.getLong("cateFk"));
				menuItem.setMenuName(rs.getString("menuName"));
				menuItem.setMenuSize(rs.getString("menuSize"));
				menuItem.setMenuPrice(rs.getLong("menuPrice"));
				menuItem.setImgUrl(rs.getString("imgUrl"));
				menuItem.setCategory(new Category(rs.getString("cateType"),rs.getString("cateName")));
				
				return menuItem;
			}
		}, cateFk);
	}
	
	/**
	 * 메뉴삭제
	 * @param mid
	 * @return
	 */
	public int DeleteMenu(MenuItem menuItem) {
		String sql = "DELETE FROM MenuItem WHERE mid=?";
		return jdbcTemplate.update(sql, menuItem.getMid());
	}
	
	public List<MenuItem> getMenuItemCart() {
		String sql="SELECT mid, menuName, menuSize, menuPrice, FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
	/**
	 * 카트리스트안에 담길 메뉴이름과 가격
	 * @return
	 */
	public List<MenuItem> inCartList(long mid){
		String sql = "SELECT mid, menuName, menuPrice FROM MenuItem WHERE mid=?";
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem();
				menuItem.setMid(rs.getLong("mid"));
				menuItem.setMenuName(rs.getString("menuName"));
				menuItem.setMenuPrice(rs.getLong("menuPrice"));
				
				return menuItem;
			}
		},mid);
	}
	
}