package com.jmaster.shopbanhang.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	
	private Long id;
	
	@NotEmpty
	private String name;
	
	private int age;
	
	@NotEmpty 
	private String username;
	
	@NotEmpty
	private String password;
}
