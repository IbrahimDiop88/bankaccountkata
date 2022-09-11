package com.bankaccountkata.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bankaccountkata.dto.CustomerOperationDto;
import com.bankaccountkata.dto.OperationDto;
import com.bankaccountkata.dto.OperationListDto;
import com.bankaccountkata.entity.Account;
import com.bankaccountkata.entity.Customer;
import com.bankaccountkata.entity.Operation;
import com.bankaccountkata.entity.OperationType;
import com.bankaccountkata.exceptions.ResourceNotFoundException;
import com.bankaccountkata.mapper.OperationMapper;
import com.bankaccountkata.repository.AccountRepository;
import com.bankaccountkata.repository.CustomerRepository;
import com.bankaccountkata.repository.OperationRepository;

@Service
public class CustomerOperationService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OperationRepository operationRepository;

	public OperationDto makeDepositInAccount(CustomerOperationDto customerOperationDto) {
		final Customer customer = searchCustomer(customerOperationDto.getCustomerName(),
				customerOperationDto.getCustomerPhone());
		Account account = searchAccount(customer, customerOperationDto.getAccountType());
		Operation operation = saveOperation(account, OperationType.CREDIT, customerOperationDto.getAmount());
		account.setBalance(account.getBalance().add(operation.getAmount()));
		accountRepository.save(account);
		return OperationMapper.INSTANCE.toDto(operation);
	}

	public OperationDto makeWihtdrawalFromAccount(CustomerOperationDto customerOperationDto) {
		final Customer customer = searchCustomer(customerOperationDto.getCustomerName(),
				customerOperationDto.getCustomerPhone());
		Account account = searchAccount(customer, customerOperationDto.getAccountType());
		Assert.isTrue(account.getBalance().compareTo(new BigDecimal(customerOperationDto.getAmount())) >= 0,
				"operation amount is more than account balance");
		Operation operation = saveOperation(account, OperationType.DEBIT, customerOperationDto.getAmount());
		account.setBalance(account.getBalance().subtract(operation.getAmount()));
		accountRepository.save(account);
		return OperationMapper.INSTANCE.toDto(operation);
	}

	public OperationListDto searchOperation(String customerName, String customerPhone, String accountType) {
		final Customer customer = searchCustomer(customerName, customerPhone);
		final Account account = searchAccount(customer, accountType);
		OperationListDto operationListDto = new OperationListDto();
		operationListDto.setOperationList(account.getOperationList().stream().map(opertion -> OperationMapper.INSTANCE.toDto(opertion))
				.collect(Collectors.toList()));
		 return operationListDto;
	}

	private Customer searchCustomer(String name, String phone) {
		Optional<Customer> customer = customerRepository.findByNameAndPhone(name, phone);
		if (customer.isEmpty()) {
			throw new ResourceNotFoundException("customer not found");
		}
		return customer.get();
	}

	private Account searchAccount(Customer customer, String accountType) {
		Optional<Account> account = accountRepository.findByCustomerAndType(customer, accountType);
		if (account.isEmpty()) {
			throw new ResourceNotFoundException("account not found");
		}
		return account.get();
	}

	private Operation saveOperation(Account account, OperationType operationType, String amount) {
		Operation operation = new Operation();
		operation.setType(operationType);
		operation.setAmount(new BigDecimal(amount));
		operation.setAccount(account);
		return operationRepository.save(operation);
	}
}
