package com.varxyz.javacafe.controller;



import org.springframework.web.multipart.MultipartFile;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private long mid;
	private long cateFk;
	private String menuName;
	private String menuSize;
	private double menuPrice;
	private MultipartFile file;
	private String imgUrl;
	
}