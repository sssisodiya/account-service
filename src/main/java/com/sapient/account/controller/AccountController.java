package com.sapient.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.account.model.Account;
import com.sapient.account.service.AccountService;

@RestController
@RequestMapping("/apis/v1/")
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
	public List<Account> getAllAccounts(@PathVariable String customerId) {

		List<Account> accounts = accountService.getAllAccounts(customerId);
		return accounts;
	}

	@RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable String customerId, @PathVariable String accountId) {

		Account account = accountService.getAccountById(accountId, customerId);
		return account;
	}

	@RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
	public Account createAccount(@PathVariable String customerId, @RequestBody Account account) {

		Account createdAccount = accountService.createAccount(customerId, account);
		return createdAccount;

	}

	@RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.PUT)
	public Account updateAccount(@PathVariable String customerId, @PathVariable String accountId,
			@RequestBody Account account) {

		Account updatedaccount = accountService.updateAccount(accountId, customerId, account);
		return updatedaccount;

	}

	@RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.DELETE)
	public void deleteAccountById(@PathVariable String accountId, @PathVariable String customerId) {

		 accountService.deleteAccount(accountId, customerId);

	}

}
