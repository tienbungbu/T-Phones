package com.jmaster.shopbanhang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemEntity {
	private int productId;
	private String name;
	private int quantity;
	private double price;
}
