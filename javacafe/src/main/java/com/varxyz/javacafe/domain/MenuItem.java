package com.varxyz.javacafe.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MenuItem {
	private long mid;
	private long cateFk;   //fk
	private Category Category;
	private String cafeName; //결국 나중에 command로 바꿔야하고 jsp에 있는ㄴ path는 무조건 여기 있어야한다고 함!
	private String menuName;
	private String menuSize;
	private double menuPrice;
	private MultipartFile file;
	private String imgUrl;
	private Date regDate;
	
	public MenuItem() {
	}
	
	public MenuItem(long mid) {
		this.mid = mid;
	}
	
	public MenuItem(String menuName, String menuSize, double menuPrice, String imgUrl,
			Category Category, Date regDate) {
		this.Category = Category;
		this.menuName = menuName;
		this.menuSize = menuSize;
		this.menuPrice = menuPrice;
		this.imgUrl = imgUrl;
		this.regDate = regDate;
	}

}