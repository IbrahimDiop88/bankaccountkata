package com.bankaccountkata.dto;

import java.io.Serializable;
import java.util.List;

public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 75314852549119928L;

	private String id;
	private String type;
	private String name;
	private String address;
	private String phone;
	private List<AccountDto> accountList;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<AccountDto> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountDto> accountList) {
		this.accountList = accountList;
	}

}
