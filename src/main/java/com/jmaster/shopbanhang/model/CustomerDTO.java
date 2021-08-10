package com.jmaster.shopbanhang.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	private int customerId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private Date registerDate;
	private short status;
}
