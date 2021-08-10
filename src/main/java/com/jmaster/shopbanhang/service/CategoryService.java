package com.jmaster.shopbanhang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jmaster.shopbanhang.entity.CategoryEntity;

public interface CategoryService {

	CategoryEntity getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends CategoryEntity> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(CategoryEntity entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<CategoryEntity> entities);

	<S extends CategoryEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends CategoryEntity> S saveAndFlush(S entity);

	void flush();

	<S extends CategoryEntity> List<S> saveAll(Iterable<S> entities);

	Optional<CategoryEntity> findById(Long id);

	List<CategoryEntity> findAllById(Iterable<Long> ids);

	List<CategoryEntity> findAll(Sort sort);

	List<CategoryEntity> findAll();

	Page<CategoryEntity> findAll(Pageable pageable);

	<S extends CategoryEntity> S save(S entity);

	List<CategoryEntity> findByName(String name);

	Page<CategoryEntity> findByName(String name, Pageable pageable);

}
