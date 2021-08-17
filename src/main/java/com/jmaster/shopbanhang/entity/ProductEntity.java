package com.jmaster.shopbanhang.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column(length = 200)
	private String image;
	
	@Column(columnDefinition = "nvarchar(500) not null")
	private String descreption;
	
	@Column(nullable = false)
	private double discount;
	
	@Temporal(value = TemporalType.DATE)
	private Date enteredDate; //java util
	
	@Column(nullable = false)
	private short status;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private CategoryEntity categoryEntity;
	
	@OneToMany( mappedBy = "productEntity",cascade = CascadeType.ALL)
	private Set<OrderDetailEntity> orderDetailEntities;
}
