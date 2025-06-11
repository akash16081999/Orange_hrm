package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.pages.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminUserManagementTest extends BaseTest {


    @Test(groups = {"Adminuser", "smoke", "reg"})
    public void addUserWithValidData() {
        PageManager.getPageManagerObj().getLoginpageObject().login();

        PageManager.getPageManagerObj().getAdminUserManagementObject().addUser();
        boolean result = PageManager.getPageManagerObj().getAdminUserManagementObject().userRecordsList("kumar  kumar");
        Assert.assertTrue(result);
        PageManager.getPageManagerObj().getAdminUserManagementObject().deleteUserFromAdminUserManagement("kumar");


    }


    @Test(groups = {"reg", "Adminuser"})
    public void existingUserValidation() {
        PageManager.getPageManagerObj().getLoginpageObject().login();
        PageManager.getPageManagerObj().getAdminUserManagementObject().addUser();
        PageManager.getPageManagerObj().getAdminUserManagementObject().addUser();
        Assert.assertTrue(PageManager.getPageManagerObj().getAdminUserManagementObject().userNameAlreadyExist().isDisplayed());
        Assert.assertEquals(PageManager.getPageManagerObj().getAdminUserManagementObject().userNameAlreadyExist().getText(), "Already exists");
        PageManager.getPageManagerObj().getAdminUserManagementObject().deleteUserFromAdminUserManagement("kumar");


    }


}
