package com.jmaster.shopbanhang.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmaster.shopbanhang.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	List<CategoryEntity> findByName(String name);
	
	Page<CategoryEntity> findByName(String name, Pageable pageable); // phan trang
}
