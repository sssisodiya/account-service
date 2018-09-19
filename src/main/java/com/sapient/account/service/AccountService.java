package com.sapient.account.service;

import java.util.List;

import com.sapient.account.model.Account;

public interface AccountService {

	public List<Account> getAllAccounts(String customerId);

	public Account getAccountById(String id, String customerId);

	public Account createAccount(String customerId, Account account);

	public Account updateAccount(String id, String customerId, Account account);

	public void deleteAccount(String id, String customerId);
}
