package com.sapient.account.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sapient.account.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	//Account findById(String id);

	List<Account> findAllByCustomerId(String customerId);
	Account findById(String id, String customerId );
	
	//void deleteById(String id);
	
	void deleteById(String id, String customerId);

}
