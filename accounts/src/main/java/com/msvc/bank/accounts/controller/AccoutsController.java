package com.msvc.bank.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.bank.accounts.model.Accounts;
import com.msvc.bank.accounts.model.Customer;
import com.msvc.bank.accounts.repository.AccountsRepository;

@RestController
public class AccoutsController {

	@Autowired
	private AccountsRepository accountsRepository;

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		}

		return null;
	}
}
