package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.base.DriverFactory;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginToOrangeHrm() {
        LoginPage lp = new LoginPage(DriverFactory.getDr());
        lp.login();
        Assert.assertEquals(DriverFactory.getDr().getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/indexfjjfgdjhg");

    }
}
