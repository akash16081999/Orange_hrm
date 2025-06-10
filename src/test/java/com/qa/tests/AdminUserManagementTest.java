package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.pages.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminUserManagementTest extends BaseTest {


    @Test(groups = {"Adminuser"})
    public void addUserWithValidData() {

        PageManager.getPageManagerObj().getAdminUserManagementObject().addUser();
        boolean result = PageManager.getPageManagerObj().getAdminUserManagementObject().userRecordsList("Akash");
        Assert.assertTrue(result);
        PageManager.getPageManagerObj().getAdminUserManagementObject().deleteUserFromAdminUserManagement("Akash");


    }

}
