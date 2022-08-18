package com.walgreens.qa.register;

import org.testng.annotations.Test;
import com.walgreens.qa.base.BaseClass;

public class RegistrationTestParameter extends BaseClass{

	@Test(enabled = true)
	public void register() {
		homePage.clickAccountSteps();
		registration.createAccountSteps("Create Your Walgreens.com Account", "Tenzin", "Nyandak", "tenzinbmx@gmail.com", "Walgreens123");
		}
	
}