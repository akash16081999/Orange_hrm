package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.pages.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(groups = {"reg", "dashboard"})
    public void dashboardLoadCheck() {

        PageManager.getPageManagerObj().getLoginpageObject().login();
        Assert.assertTrue(PageManager.getPageManagerObj().getDashboardPageObject().getTimeAtWork().isDisplayed());
        Assert.assertEquals(PageManager.getPageManagerObj().getDashboardPageObject().getTimeAtWork().getText(), "Time at Work");
    }

    @Test(groups = {"reg", "dashboard"})
    public void logoutValidation() {
        PageManager.getPageManagerObj().getLoginpageObject().login();
        PageManager.getPageManagerObj().getDashboardPageObject().logOut();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @Test(groups = {"reg", "dashboard"})
    public void unauthorizedAccessAfterLogout() {
        PageManager.getPageManagerObj().getLoginpageObject().login();
        PageManager.getPageManagerObj().getDashboardPageObject().logOut();
        getDriver().navigate().back();
        getDriver().navigate().refresh();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

}
