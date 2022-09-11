package com.bankaccountkata.dto;

import java.io.Serializable;

import com.bankaccountkata.entity.OperationType;

public class CustomerOperationDto implements Serializable {

	private static final long serialVersionUID = -3511897434819757696L;
	private String customerName;
	private String customerPhone;
	private String accountType;
	private OperationType operationType;
	private String amount;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
