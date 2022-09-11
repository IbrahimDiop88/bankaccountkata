package com.bankaccountkata.cucumbertesting.service;

import org.junit.Assert;
import org.springframework.web.client.RestTemplate;

import com.bankaccountkata.cucumbertesting.CucumberDatas;
import com.bankaccountkata.cucumbertesting.SpringIntegrationTest;
import com.bankaccountkata.dto.CustomerOperationDto;
import com.bankaccountkata.dto.OperationListDto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeeOperationHistory extends SpringIntegrationTest {

	CucumberDatas cucumberDatas;

	public SeeOperationHistory(CucumberDatas cucumberDatas) throws Throwable {
		super();
		this.cucumberDatas = cucumberDatas;
	}

	@Given("The customer name {string} and phone {string} with account type {string} want to see operation history")
	public void the_customer_name_and_phone_with_account_type_want_to_see_operation_history(String name, String phone,
			String accountType) {
		CustomerOperationDto customerOperationDto = new CustomerOperationDto();
		customerOperationDto.setAccountType(accountType);
		customerOperationDto.setCustomerName(name);
		customerOperationDto.setCustomerPhone(phone);
		this.cucumberDatas.setCustomerOperationDto(customerOperationDto);
	}

	@When("the client calls \\/operations\\/...")
	public void the_client_calls_operations() {
		OperationListDto operationDto = new RestTemplate().getForObject(
				"http://localhost:8080/operations/" + this.cucumberDatas.getCustomerOperationDto().getCustomerName()
						+ "/" + this.cucumberDatas.getCustomerOperationDto().getCustomerPhone() + "/"
						+ this.cucumberDatas.getCustomerOperationDto().getAccountType(),
				OperationListDto.class);
		this.cucumberDatas.setOperationList(operationDto.getOperationList());
	}

	@Then("the client receives list of operation")
	public void the_client_receives_list_of_operation() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertNotNull(this.cucumberDatas.getOperationList());
	}
}
