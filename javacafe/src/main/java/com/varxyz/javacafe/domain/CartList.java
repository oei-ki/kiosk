package com.varxyz.javacafe.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartList {
	private ArrayList<CartArgument> cartList;
	
}
