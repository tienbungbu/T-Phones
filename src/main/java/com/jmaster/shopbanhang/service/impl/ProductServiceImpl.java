package com.jmaster.shopbanhang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jmaster.shopbanhang.dao.ProductRepository;
import com.jmaster.shopbanhang.entity.ProductEntity;
import com.jmaster.shopbanhang.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public <S extends ProductEntity> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public <S extends ProductEntity> Optional<S> findOne(Example<S> example) {
		return productRepository.findOne(example);
	}

	@Override
	public Page<ProductEntity> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

	@Override
	public List<ProductEntity> findAllById(Iterable<Long> ids) {
		return productRepository.findAllById(ids);
	}

	@Override
	public Optional<ProductEntity> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public <S extends ProductEntity> List<S> saveAll(Iterable<S> entities) {
		return productRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		productRepository.flush();
	}

	@Override
	public <S extends ProductEntity> S saveAndFlush(S entity) {
		return productRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return productRepository.existsById(id);
	}

	@Override
	public <S extends ProductEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ProductEntity> entities) {
		productRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ProductEntity> long count(Example<S> example) {
		return productRepository.count(example);
	}

	@Override
	public <S extends ProductEntity> boolean exists(Example<S> example) {
		return productRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ProductEntity> entities) {
		productRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		productRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ProductEntity entity) {
		productRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		productRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		productRepository.deleteAllInBatch();
	}

	@Override
	public ProductEntity getOne(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ProductEntity> entities) {
		productRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public ProductEntity getById(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public <S extends ProductEntity> List<S> findAll(Example<S> example) {
		return productRepository.findAll(example);
	}

	@Override
	public <S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort) {
		return productRepository.findAll(example, sort);
	}
	
	
}
