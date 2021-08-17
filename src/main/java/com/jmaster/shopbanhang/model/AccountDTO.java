package com.jmaster.shopbanhang.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
}
