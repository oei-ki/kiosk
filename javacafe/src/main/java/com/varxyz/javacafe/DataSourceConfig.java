package com.varxyz.javacafe;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.javacafe.dao.CartDao;
import com.varxyz.javacafe.dao.CategoryDao;
import com.varxyz.javacafe.dao.MenuItemDao;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.CategoryServiceImpl;
import com.varxyz.javacafe.service.MenuItemServiceImpl;


@Configuration
@ComponentScan(basePackages = "com.varxyz.javacafe.dao")
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {  //dataSource클로즈는 종료가 아니라 다시 불러들이는거임?
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/javacafe?severTimezone=Asia/Seoul");
		ds.setUsername("javacafe");
		ds.setPassword("javacafe");
		ds.setInitialSize(2); //커넥션 풀 초기화시 생성할 초기 커넥션 갯수(기본값 10)
		ds.setMaxActive(10);  //풀에서 가져올 수 있는 최대 커넥션 갯구(기본값 100)
		ds.setMaxIdle(10);    //풀에 유지할 수 있는 최대 커넥션 수(기본값은 maxActive와 동일)
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public CategoryDao categoryDao() {
		return new CategoryDao(dataSource());
	}
	
	@Bean
	public CategoryServiceImpl categoryService () {
		return new CategoryServiceImpl();
	}
	
	@Bean
	public MenuItemDao menuItemDao() {
		return new MenuItemDao(dataSource());
	}
	
	@Bean
	public MenuItemServiceImpl menuItemService() {
		return new MenuItemServiceImpl();
	}
	
	@Bean
	public CartDao cartDao() {
		return new CartDao(dataSource());
	}
	
	@Bean
	public CartServiceImpl cartService() {
		return new CartServiceImpl();
	}
}