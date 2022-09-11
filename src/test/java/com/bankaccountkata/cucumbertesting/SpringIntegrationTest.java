package com.bankaccountkata.cucumbertesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.bankaccountkata.BankAccountKataApplicationTests;
import com.bankaccountkata.dto.AccountDto;
import com.bankaccountkata.dto.CustomerDto;
import com.bankaccountkata.repository.AccountRepository;
import com.bankaccountkata.repository.CustomerRepository;
import com.bankaccountkata.repository.OperationRepository;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = BankAccountKataApplicationTests.class)
@javax.transaction.Transactional
public class SpringIntegrationTest {

	@Autowired
	protected CustomerRepository customerRepository;

	@Autowired
	protected AccountRepository accountRepository;

	@Autowired
	protected OperationRepository operationRepository;

	protected void insertData() throws Exception {
		CustomerDto customer = new CustomerDto();
		customer.setName("DIOP");
		customer.setPhone("07777777");
		customer.setAddress("2 xxx");
		customer.setType("person");

		AccountDto account = new AccountDto();
		account.setType("current");
		account.setBalance("1000");
		account.setCustomer(customer);

		HttpEntity<AccountDto> request = new HttpEntity<>(account);
		new RestTemplate().postForObject("http://localhost:8080/account/", request, Void.class);

	}

}
