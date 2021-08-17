package com.jmaster.shopbanhang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jmaster.shopbanhang.entity.ProductEntity;

public interface ProductService {

	<S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends ProductEntity> List<S> findAll(Example<S> example);

	ProductEntity getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends ProductEntity> entities);

	ProductEntity getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(ProductEntity entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<ProductEntity> entities);

	<S extends ProductEntity> boolean exists(Example<S> example);

	<S extends ProductEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<ProductEntity> entities);

	<S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ProductEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends ProductEntity> S saveAndFlush(S entity);

	void flush();

	<S extends ProductEntity> List<S> saveAll(Iterable<S> entities);

	Optional<ProductEntity> findById(Long id);

	List<ProductEntity> findAllById(Iterable<Long> ids);

	List<ProductEntity> findAll(Sort sort);

	List<ProductEntity> findAll();

	Page<ProductEntity> findAll(Pageable pageable);

	<S extends ProductEntity> Optional<S> findOne(Example<S> example);

	<S extends ProductEntity> S save(S entity);

}
