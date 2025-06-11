package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {

    private final WebElement timeAtWork;
    private final WebDriver driver;
    private final WebElement userProfileDropdownBtn;
    private List<WebElement> userProfileDropwdownlist;

    DashboardPage(WebDriver driver) {
        this.driver = driver;
        timeAtWork = this.driver.findElement(By.xpath("(//div[@class='orangehrm-dashboard-widget-name'])[1]"));
        userProfileDropdownBtn = this.driver.findElement(By.cssSelector(".oxd-userdropdown"));

    }


    public WebElement getTimeAtWork() {
        return timeAtWork;
    }


    public void logOut() {

        userProfileDropdownBtn.click();
        userProfileDropdownList("Logout");

    }

    private void userProfileDropdownList(String value) {
        userProfileDropwdownlist = this.driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li"));

        for (WebElement ele : userProfileDropwdownlist) {

            if (ele.getText().equals(value)) {
                ele.click();
                break;
            }
        }

    }
}
