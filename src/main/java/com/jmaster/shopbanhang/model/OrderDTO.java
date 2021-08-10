package com.jmaster.shopbanhang.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	private int orderId;
	private Date orderDate;
	private int customerId;
	private double amount;
	private short status;
}
