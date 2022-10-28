package com.varxyz.javacafe.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.javacafe.domain.Category;
import com.varxyz.javacafe.domain.MenuItem;

public class CategoryDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * 관리자 카테고리 추가
	 * @param category
	 */
	public void addCategory(Category category) {
		String sql = "INSERT INTO Category (cateType, cateName) VALUES (?,?)"; 
		jdbcTemplate.update(sql, category.getCateType(), category.getCateName());
	}
	/**
	 * 대분류로 조회가능하게 만들고 중분류로도 연결되게 만들기
	 * 음...대분류는 그냥 만들고 중분류에서 대분류에 포함된상태로 중분류로 조회가능하게 만드나?
	 * cateType = 커피 / 음료 / 디저트
	 * cateName = 카페인, 디카페인 / 차, 에이드, 스무디, 라떼 / 케잌, 마카롱, 빵/
	 * @return 
	 */
	
	public List<Category> getCategory() {
		String sql= "SELECT * FROM Category";
		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}
	
	public Category getSubCategory(String cateName) {
		String sql="SELECT cid, cateType, cateName, regDate FROM Category WHERE cateName=?";
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), cateName);
	}
	

	/**
	 * 카테고리삭제
	 * 이거 매개변수 값을 카테고리를 받는지 cid를 받는지 모르겠음
	 * @param category
	 * @return
	 */
	public int deleteCategory(Category category) {
		String sql = "DELETE FROM Category WHERE cid = ?";
			return jdbcTemplate.update(sql, category.getCid());
	}
	
}