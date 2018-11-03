package com.w2a.zoho.testcases;

import com.w2a.zoho.PageObjects.ZohoAppPage;
import com.w2a.zoho.PageObjects.ZohoHomePage;
import com.w2a.zoho.PageObjects.ZohoLoginPage;
import com.w2a.zoho.utilities.Constants;
import com.w2a.zoho.utilities.DataProviders;
import com.w2a.zoho.utilities.DataUtil;
import com.w2a.zoho.utilities.ExcelReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ValidateCRMTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class,dataProvider = "masterDP")
    public void validateCRMTest(HashMap<String,String> data){

        ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
        DataUtil.checkExecution("master", "ValidateCRMTest", data.get("Runmode"),excel);
        logInfo("Inside Validate CRM Test");
        openBrowser(data.get("browser"));
        logInfo("Launched Browser : " + data.get("browser"));
        ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/");
        ZohoLoginPage login = home.gotoLogin();
        ZohoAppPage app = login.doLoginAsValidUser(getDefaultUserName(),getDefaultPassword());
        logInfo("Username entered as " + getDefaultUserName() + " and Password entered as " + getDefaultPassword());
        app.gotoCRM();

        //Assert.fail("Failing the login test");
    }

    @AfterMethod
    public void tearDown(){
        logInfo("Login Test Completed");
        quit();
    }
}
