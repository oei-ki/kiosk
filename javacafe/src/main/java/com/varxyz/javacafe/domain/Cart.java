package com.varxyz.javacafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	private long caid;
	private long orderid;
	private String menuName;
	private int number;
	private double menuPrice;
	private Date regDate;
	
	public static long orderNum = 1;
	
}
