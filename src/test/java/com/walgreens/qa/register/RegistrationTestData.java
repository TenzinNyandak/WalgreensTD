package com.walgreens.qa.register;

import com.walgreens.qa.base.BaseClass;
import com.walgreens.qa.utils.RegistrationData;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class RegistrationTestData extends BaseClass{

	@DataProvider(name = "registrationDataIterator")
	public Iterator<RegistrationData> registrationDataIterator() {
		List<RegistrationData> list = new ArrayList<RegistrationData>();
		RegistrationData registrationData1 = new RegistrationData("Create Your Walgreens.com Account", "John",
				"Wallace", "johnwallace@gmail.com", "Wall4567");
		RegistrationData registrationData2 = new RegistrationData("Create Your Walgreens.com Account", "Steven",
				"Smith", "stevensmith@gmail.com", "Smith369");
		list.add(registrationData1);
		list.add(registrationData2);
		return list.iterator();
	}

	@DataProvider(name = "registrationDataObject")
	public Object[][] registrationDataObject() {
		RegistrationData registrationData1 = new RegistrationData("Create Your Walgreens.com Account", "Emannuel",
				"Garcia", "e_man@gmail.com", "Garema246");
		RegistrationData registrationData2 = new RegistrationData("Create Your Walgreens.com Account", "James", "Dean",
				"james_dean@gmail.com", "Jamdea369");
		return new Object[][] { { registrationData1 }, { registrationData2 } };
	}

	@Test(enabled = true, dataProvider = "registrationDataIterator")
	public void register(RegistrationData registrationData) {
		homePage.clickAccountSteps();
		registration.createAccountSteps(registrationData);
	}
}
