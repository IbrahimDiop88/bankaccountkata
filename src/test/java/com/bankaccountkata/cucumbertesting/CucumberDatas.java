
package com.bankaccountkata.cucumbertesting;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bankaccountkata.dto.CustomerOperationDto;
import com.bankaccountkata.dto.OperationDto;

@Component
public class CucumberDatas {

	private CustomerOperationDto customerOperationDto;
	private OperationDto operationDto;
	List<OperationDto> operationList;

	public CucumberDatas() {
	}

	public CustomerOperationDto getCustomerOperationDto() {
		return customerOperationDto;
	}

	public void setCustomerOperationDto(CustomerOperationDto customerOperationDto) {
		this.customerOperationDto = customerOperationDto;
	}

	public OperationDto getOperationDto() {
		return operationDto;
	}

	public void setOperationDto(OperationDto operationDto) {
		this.operationDto = operationDto;
	}

	public List<OperationDto> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<OperationDto> operationList) {
		this.operationList = operationList;
	}

}
