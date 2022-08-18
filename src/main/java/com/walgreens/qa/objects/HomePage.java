package com.walgreens.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walgreens.qa.commons.CommonFunctions;

public class HomePage {

	CommonFunctions commons;

	public HomePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath = "//strong[contains(text(),'Account')]")
	WebElement account;

	@FindBy(xpath = "//a[@id='pf-dropdown-register']")
	WebElement register;

	private void clickAccount() {
		commons.click(account);
	}

	private void clickRegister() {
		commons.click(register);
	}

	public void clickAccountSteps() {
		clickAccount();
		clickRegister();
	}
}