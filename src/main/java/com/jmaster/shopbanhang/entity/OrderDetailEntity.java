package com.jmaster.shopbanhang.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;
	
//	@Column(nullable = false)
//	private int orderId;
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderEntity orderEntity;
	
	
//	@Column(nullable = false)
//	private int productId;
	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductEntity productEntity;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
}
