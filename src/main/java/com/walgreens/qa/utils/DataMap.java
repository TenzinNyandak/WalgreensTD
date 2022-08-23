package com.walgreens.qa.utils;

public enum DataMap {

	Title("Title"), FirstName("First Name"), LastName("Last Name"), Email("Email"), Password("Password");

	private String value;

	private DataMap(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
