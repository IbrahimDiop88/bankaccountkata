package com.bankaccountkata.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.bankaccountkata.entity.OperationType;

public class OperationDto implements Serializable {

	private static final long serialVersionUID = 364611752549119928L;

	private String id;
	private OperationType type;
	private LocalDateTime date;
	private String amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
