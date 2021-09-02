package com.jmaster.shopbanhang.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmaster.shopbanhang.dao.AccountRepository;
import com.jmaster.shopbanhang.entity.AccountEntity;
import com.jmaster.shopbanhang.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public <S extends AccountEntity> S save(S entity) {
		return accountRepository.save(entity);
	}

	@Override
	public List<AccountEntity> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<AccountEntity> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public <S extends AccountEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return accountRepository.findAll(example, pageable);
	}

	@Override
	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void delete(AccountEntity entity) {
		accountRepository.delete(entity);
	}

	@Override
	public AccountEntity getOne(String id) {
		return accountRepository.getOne(id);
	}

	@Override
	public AccountEntity getById(String id) {
		return accountRepository.getById(id);
	}
	
	
}
