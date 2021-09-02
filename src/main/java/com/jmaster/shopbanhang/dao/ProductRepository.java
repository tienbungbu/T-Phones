package com.jmaster.shopbanhang.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmaster.shopbanhang.entity.ProductEntity;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
}
