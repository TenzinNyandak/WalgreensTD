package com.walgreens.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.walgreens.qa.commons.CommonFunctions;
import com.walgreens.qa.utils.RegistrationData;

public class Registration {
	
	CommonFunctions commons;

	public Registration(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}
	
	@FindBy(xpath = "//h1[text()='Create Your Walgreens.com Account']")
	WebElement titleElement;
	
	@FindBy(xpath = "//input[@id='wag-RXUser-firstname']")
	WebElement firstNameElement;
	
	@FindBy(xpath = "//input[@id='wag-RXUser-lastname']")
	WebElement lastNameElement;
	
	@FindBy(xpath = "//input[@id='wag-email']")
	WebElement emailElement;
	
	@FindBy(xpath = "//input[@id='wag-password']")
	WebElement passwordElement;
	
	@FindBy (xpath = "//input[@id='wag-terms-checkbox']")
	WebElement acceptTermsElement;
	
	@FindBy (xpath = "//a[@id='wag-rxuser-continue-btm']")
	WebElement continueElement;
	
	
	private void getTitle(String expectedTitle) {
	Assert.assertEquals(commons.getText(titleElement),expectedTitle);
	}
	
	private void inputFirstName(String value) {
		commons.inputValues(firstNameElement, value);
	}

	private void inputLastName(String value) {
		commons.inputValues(lastNameElement, value);
	}

	private void inputEmail(String value) {
		commons.inputValues(emailElement, value);
	}

	private void inputPassword(String value) {
		commons.inputValues(passwordElement, value);
	}
	
	private void checkAcceptTerms() {
		commons.checkBox(acceptTermsElement);
	}
	
	private void clickContinue() {
		commons.click(continueElement);
	}
	
	public void createAccountSteps(String expectedTitle, String value1, String value2, String value3, String value4) {
		getTitle(expectedTitle);
		inputFirstName(value1);
		inputLastName(value2);
		inputEmail(value3);
		inputPassword(value4);
		checkAcceptTerms();
		clickContinue();
	}
	
	public void createAccountSteps(RegistrationData registrationData) {
		getTitle(registrationData.getExpectedTitle());
		inputFirstName(registrationData.getFirstName());
		inputLastName(registrationData.getLastName());
		inputEmail(registrationData.getEmail());
		inputPassword(registrationData.getPassword());
		checkAcceptTerms();
		clickContinue();
	}
}