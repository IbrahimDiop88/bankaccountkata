package com.bankaccountkata.entity;

public enum OperationType {
	DEBIT("DEBIT"), CREDIT("CREDIT");

	private String value;

	OperationType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static OperationType fromValue(String text) {
		for (OperationType b : OperationType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
