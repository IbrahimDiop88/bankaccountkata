package com.bankaccountkata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccountkata.dto.AccountDto;
import com.bankaccountkata.entity.Account;
import com.bankaccountkata.entity.Customer;
import com.bankaccountkata.mapper.AccountMapper;
import com.bankaccountkata.repository.AccountRepository;
import com.bankaccountkata.repository.CustomerRepository;

@Service
public class AccountService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	
	public void saveAccount(AccountDto accountDto) {
		// just to tests with cucumber
		Account account = AccountMapper.INSTANCE.toEntity(accountDto);
		Optional<Customer> customer = customerRepository.findByNameAndPhone(account.getCustomer().getName(),
				account.getCustomer().getPhone());
		if (customer.isEmpty()) {
			customerRepository.save(account.getCustomer());
			accountRepository.save(account);
		}
	}
}
