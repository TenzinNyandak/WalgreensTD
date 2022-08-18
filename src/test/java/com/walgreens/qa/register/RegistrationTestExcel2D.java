package com.walgreens.qa.register;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.walgreens.qa.base.BaseClass;
import com.walgreens.qa.utils.ExcelUtil;

public class RegistrationTestExcel2D extends BaseClass{

	@DataProvider(name = "registrationData2DExcel")
	public Object[][] registrationData (){
		String path = configuration.getConfig("excelPath");
		String sheetName = configuration.getConfig("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(path, sheetName);
		return excelUtil.dataObjects();
	}

	@Test(enabled = true, dataProvider = "registrationData2DExcel")
	public void register(String expectedTitle, String value1, String value2, String value3, String value4) {
		homePage.clickAccountSteps();
		registration.createAccountSteps(expectedTitle, value1, value2, value3, value4);
	}
}
