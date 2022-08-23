package com.walgreens.qa.register;

import org.testng.annotations.Test;
import java.util.Map;
import org.testng.annotations.DataProvider;
import static com.walgreens.qa.utils.DataMap.*;
import com.walgreens.qa.base.BaseClass;
import com.walgreens.qa.utils.ExcelUtil;

public class RegistrationTestMapDataProvider  extends BaseClass{
	
	@DataProvider(name = "excelMap")
	public Object[][] mapData(){
		String pathString = configuration.getConfig("excelPath");
		String sheetNameString = configuration.getConfig("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1];

		for(int i = 0; i < size; i++) {
			objects2d[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2d;
	}
	
	@Test(enabled = true, dataProvider = "excelMap")
	public void autoDataWithMapDataProviderWithEnum(Map<String, String> map) {
		homePage.clickAccountSteps();
		registration.createAccountSteps(map.get(Title.name()), map.get(FirstName.getValue()), map.get(LastName.getValue()), map.get(Email.name()),map.get(Password.getValue()));
	}

}
