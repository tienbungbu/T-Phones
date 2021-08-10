package com.jmaster.shopbanhang.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	
	private Long categoryId;
	
	@NotEmpty
	private String name;
	
	private boolean isEdit = false;
}
