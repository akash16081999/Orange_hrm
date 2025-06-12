package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.base.DriverFactory;
import com.qa.pages.PageManager;
import com.qa.utils.Reporter;
import com.qa.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(groups = {"reg", "smoke", "login"})
    public void loginToOrangeHrm() {


        PageManager.getPageManagerObj().getLoginpageObject().login();
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

    }


    @Test(groups = {"reg", "login"}, dataProvider = "InvalidPassword", dataProviderClass = TestDataProvider.class)
    public void loginWithInvaidPassword(String username, String pass) {

        PageManager.getPageManagerObj().getLoginpageObject().login(username, pass);
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().getInvalidAlertTxt().isDisplayed());
        Assert.assertEquals(PageManager.getPageManagerObj().getLoginpageObject().getInvalidAlertTxt().getText(), "Invalid credentials");


    }

    @Test(groups = {"reg", "login"}, dataProvider = "Emptyusername", dataProviderClass = TestDataProvider.class)
    public void loginWithBlankUserName(String username, String pass) {
        PageManager.getPageManagerObj().getLoginpageObject().login(username, pass);
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().getAlertForEmptyUsername().isDisplayed());
        Assert.assertEquals(PageManager.getPageManagerObj().getLoginpageObject().getAlertForEmptyUsername().getText(), "Required");

    }

    @Test(groups = {"reg", "login"}, dataProvider = "Emptypassword", dataProviderClass = TestDataProvider.class)
    public void loginWithBlankPassword(String username, String pass) {
        PageManager.getPageManagerObj().getLoginpageObject().login(username, pass);
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().getAlertForEmptyUsername().isDisplayed());
        Assert.assertEquals(PageManager.getPageManagerObj().getLoginpageObject().getAlertForEmptyUsername().getText(), "Required");

    }

    @Test(groups = {"reg", "login"})
    public void loginPageUiButtonvisible() {

        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().usenameIsDisplayed());
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().passwordIsDisplayed());
        Assert.assertTrue(PageManager.getPageManagerObj().getLoginpageObject().loginBtnIsDisplayed());
    }

}
