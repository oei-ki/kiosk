package com.varxyz.javacafe.controller;



import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartCommand {
	private long caid;
	private long orderid;
	private String menuName;
	private int number;
	private double menuPrice;
	private Date regDate;
	
	
	
}