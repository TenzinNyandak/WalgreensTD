package com.walgreens.qa.cancelRegistration;

import org.testng.annotations.Test;
import com.walgreens.qa.base.BaseClass;

public class CancelRegistrationTest extends BaseClass {

	@Test(enabled = true)
	public void cancelRegistration() {
		homePage.clickAccountSteps();
		cancelRegistration.cancelRegistrationSteps("Create Your Walgreens.com Account","https://www.walgreens.com/login.jsp");
	}
}