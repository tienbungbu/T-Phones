package com.jmaster.shopbanhang.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private int productId;
	private String name;
	private int quantity;
	private double price;
	private String image;
	private String descreption;
	private double discount;
	private Date enteredDate; //java util
	private short status;
	private int categoryId;
}
