package com.w2a.zoho.rough;

import com.w2a.zoho.PageObjects.ZohoHomePage;
import com.w2a.zoho.PageObjects.ZohoLoginPage;
import com.w2a.zoho.testcases.BaseTest;
import com.w2a.zoho.utilities.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    public WebDriver driver;

    @Test(dataProviderClass = DataProviders.class,dataProvider = "masterDP")
    public void doLogin(String username, String password, String browser){


        openBrowser(browser);

        ZohoHomePage home = new ZohoHomePage();
        ZohoLoginPage login = home.gotoLogin();
        login.doLoginAsValidUser("trainer@way2automation.com","Selenium@1234");


        quit();
    }

}
