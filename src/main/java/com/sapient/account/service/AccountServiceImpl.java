package com.sapient.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.account.model.Account;
import com.sapient.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	public List<Account> getAllAccounts(String customerId) {

		List<Account> accounts = accountRepository.findAllByCustomerId(customerId);
		return accounts;

	}

	public Account getAccountById(String id, String customerId) {

		Account account = accountRepository.findById(id, customerId);
		return account;

	}

	public Account createAccount(String customerId, Account account) {

		account.setCustomerId(customerId);
		Account new_account = accountRepository.save(account);
		return new_account;

	}

	public Account updateAccount(String id, String customerId, Account account) {

		Account updateAccount = accountRepository.findById(id, customerId);
		updateAccount.setAmount(account.getAmount());
		updateAccount.setNumber(account.getNumber());

		Account updatedAccount = accountRepository.save(updateAccount);

		return updatedAccount;

	}

	public void deleteAccount(String id, String customerId) {

		accountRepository.deleteById(id, customerId);

	}

}
