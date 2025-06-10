package com.qa.pages;

import org.openqa.selenium.WebDriver;

public class PageManager {

    private LoginPage lp;
    private WebDriver driver;
    private static PageManager pm = null;
    private DashboardPage dp;
    private AdminUserManagementPage ap;


    public AdminUserManagementPage getAdminUserManagementObject() {
        if (ap == null) {
            ap = new AdminUserManagementPage(driver);
            return ap;
        }
        return ap;
    }

    public LoginPage getLoginpageObject() {
        if (lp == null) {
            lp = new LoginPage(driver);
            return lp;
        }
        return lp;
    }

    public DashboardPage getDashboardPageObject() {
        if (dp == null) {
            dp = new DashboardPage(driver);
            return dp;
        }
        return dp;
    }


    public static void intPageManager(WebDriver driver) {

//        if (pm == null) {
//            System.out.println("null");

        pm = new PageManager(driver);
        System.out.println("not null");

//        }
    }

    private PageManager(WebDriver driver) {
        this.driver = driver;

    }

    public static PageManager getPageManagerObj() {

        return pm;
    }

}
