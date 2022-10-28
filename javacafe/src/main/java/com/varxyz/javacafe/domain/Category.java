package com.varxyz.javacafe.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Category {
	/**
	 * 카테고리 대분류 중분류 만들어서 관리자가 추가할수 있게 만들어야 함.
	 */
	private long cid;
	private String cateType;
	private String cateName;
	private Date regDate;
	
	public Category() {
	}
	
	public Category(String cateType, String cateName) {
		super();
		this.cateType = cateType;
		this.cateName = cateName;
	}
	
	public Category(long cateFk) {
		this.cid = cateFk;
	}  //이거 뭔 역할인지 모르겠음
	
}