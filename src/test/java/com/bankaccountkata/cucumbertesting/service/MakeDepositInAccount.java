package com.bankaccountkata.cucumbertesting.service;

import static org.junit.Assert.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.bankaccountkata.cucumbertesting.CucumberDatas;
import com.bankaccountkata.cucumbertesting.SpringIntegrationTest;
import com.bankaccountkata.dto.CustomerOperationDto;
import com.bankaccountkata.dto.OperationDto;
import com.bankaccountkata.entity.OperationType;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeDepositInAccount extends SpringIntegrationTest {

	CucumberDatas cucumberDatas;

	public MakeDepositInAccount(CucumberDatas cucumberDatas) throws Throwable {
		super();
		this.cucumberDatas = cucumberDatas;
	}
	
	
    @Before
    public void init() throws Exception {
    	super.insertData();
    }

	@Given("The customer name {string} and phone {string} with account type {string} want to deposit {string}")
	public void the_customer_name_and_phone_with_account_type_want_to_deposit(String name, String phone,
			String accountType, String amount) {
		CustomerOperationDto customerOperationDto = new CustomerOperationDto();
		customerOperationDto.setAccountType(accountType);
		customerOperationDto.setCustomerName(name);
		customerOperationDto.setCustomerPhone(phone);
		customerOperationDto.setAmount(amount);
		this.cucumberDatas.setCustomerOperationDto(customerOperationDto);
	}

	@When("the client calls \\/deposit")
	public void the_client_calls_deposit() {
		// Write code here that turns the phrase above into concrete actions
		HttpEntity<CustomerOperationDto> request = new HttpEntity<>(this.cucumberDatas.getCustomerOperationDto());
		OperationDto operationDto = new RestTemplate().postForObject("http://localhost:8080/operations/deposit", request,
				OperationDto.class);
		this.cucumberDatas.setOperationDto(operationDto);
	}

	@Then("the account of client is credited")
	public void the_account_of_client_is_credited() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(OperationType.CREDIT, this.cucumberDatas.getOperationDto().getType());
	}

}
