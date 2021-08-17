package com.jmaster.shopbanhang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jmaster.shopbanhang.entity.AccountEntity;

public interface AccountService {

	AccountEntity getById(String id);

	AccountEntity getOne(String id);

	void delete(AccountEntity entity);

	void deleteById(String id);

	<S extends AccountEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<AccountEntity> findById(String id);

	List<AccountEntity> findAll();

	<S extends AccountEntity> S save(S entity);

}
