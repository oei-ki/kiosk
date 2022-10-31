package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartArgument {
	private String menuName;
	private int number;
	private double menuPrice;
}
