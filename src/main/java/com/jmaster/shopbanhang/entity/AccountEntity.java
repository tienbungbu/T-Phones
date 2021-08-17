package com.jmaster.shopbanhang.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEntity implements Serializable {
	@Id
	@Column(length = 30)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String password;
}
