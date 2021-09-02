package com.jmaster.shopbanhang.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmaster.shopbanhang.entity.AccountEntity;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
	
}
