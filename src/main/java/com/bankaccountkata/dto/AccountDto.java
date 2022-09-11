package com.bankaccountkata.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = 96375312549119928L;

	private String id;
	private String type;
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	private String balance;
	private CustomerDto customer;
	private List<OperationDto> operationList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public List<OperationDto> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<OperationDto> operationList) {
		this.operationList = operationList;
	}
}
