package com.walgreens.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.walgreens.qa.commons.CommonFunctions;

public class CancelRegistration {

	CommonFunctions commons;
	WebDriver driver;

	public CancelRegistration(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		this.driver = driver;
		}

	@FindBy(xpath = "//h1[text()='Create Your Walgreens.com Account']")
	WebElement titleElement;

	@FindBy(xpath = "//a[@id='wag-rxuser-cancel-link']")
	WebElement cancelElement;

	private void getTitle(String expectedTitle) {
		Assert.assertEquals(commons.getText(titleElement), expectedTitle);
	}
	
	private void clickCancel() {
		commons.click(cancelElement);
	}

	private void getCurrentUrl(String expectedUrl) {
		Assert.assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	public void cancelRegistrationSteps(String expectedTitle, String expectedUrl) {
		getTitle(expectedTitle);
		clickCancel();
		getCurrentUrl(expectedUrl);
	}
}
