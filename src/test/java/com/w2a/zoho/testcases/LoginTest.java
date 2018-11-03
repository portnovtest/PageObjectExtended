package com.w2a.zoho.testcases;

import com.w2a.zoho.PageObjects.ZohoHomePage;
import com.w2a.zoho.PageObjects.ZohoLoginPage;
import com.w2a.zoho.utilities.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends BaseTest {


    @Test(dataProviderClass = DataProviders.class,dataProvider = "masterDP")
    public void loginTest(HashMap<String,String> data){

        ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
        DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"),excel);
        openBrowser(data.get("browser"));
        logInfo("Launched Browser : " + data.get("browser"));
        ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/");
        ZohoLoginPage login = home.gotoLogin();
        login.doLoginAsInvalidUser(data.get("username"),data.get("password"));
        logInfo("Username entered as " + data.get("username") + " and Password entered as " + data.get("password"));
        //Assert.fail("Failing the login test");
    }

    @AfterMethod
    public void tearDown(){
        logInfo("Login Test Completed");
        quit();
    }
}
