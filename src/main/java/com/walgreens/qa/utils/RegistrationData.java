package com.walgreens.qa.utils;

public class RegistrationData {

	private String expectedTitle;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public RegistrationData(String expectedTitle, String firstName, String lastName, String email, String password) {
		this.expectedTitle = expectedTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getExpectedTitle() {
		return expectedTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
