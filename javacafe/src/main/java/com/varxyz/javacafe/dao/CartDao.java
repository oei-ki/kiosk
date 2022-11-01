package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public class CartDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CartDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addCart(Cart cart) {
		String sql = "INSERT INTO Cart (orderid, menuName, number, menuPrice) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,cart.getOrderid(), cart.getMenuName(), cart.getNumber(), cart.getMenuPrice());
	}
	
	public List<Cart> getCart() {
		String sql= "SELECT * FROM Cart";
		return jdbcTemplate.query(sql, new CartRowMapper());
	}
	
	public int DeleteCart(Cart cart) {
		String sql = "DELETE FROM Cart WHERE caid=?";
		return jdbcTemplate.update(sql, cart.getCaid());
	}
	
	public List<Cart> getAllCartToKiosk(long orderid){
		String sql = "SELECT caid, orderid, menuName, number, menuPrice FROM Cart";
		return jdbcTemplate.query(sql, new RowMapper<Cart>() {

			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart cart = new Cart();
				cart.setCaid(rs.getLong("cateFk"));
				cart.setOrderid(Cart.orderNum);
				cart.setMenuName(rs.getString("menuName"));
				cart.setNumber(rs.getInt("number"));
				cart.setMenuPrice(rs.getDouble("menuPrice"));
				return cart;
			}
		}, orderid);
	}
	
	/**
	 * 모달창 결제하기 s주문번호로 찾기
	 * @param orderid
	 * @return
	 */
	public List<Cart> getPayCart(long orderid) {
		String sql="SELECT caid, orderid, menuName, number, menuPrice, regDate FROM Cart WHERE orderid=?";
		return jdbcTemplate.query(sql, new CartRowMapper(), orderid);
		//queryForObject 객체 하나만 받아와서 문제 
	}
}
