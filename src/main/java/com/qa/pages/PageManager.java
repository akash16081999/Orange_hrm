package com.qa.pages;

import org.openqa.selenium.WebDriver;

public class PageManager {
    private static ThreadLocal<PageManager> pm = new ThreadLocal<>();
    private LoginPage lp;
    private WebDriver driver;
    //private static PageManager pm = null;
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
        pm.set(new PageManager(driver));
    }

    private PageManager(WebDriver driver) {
        this.driver = driver;

    }

    public static PageManager getPageManagerObj() {

        return pm.get();
    }

}
