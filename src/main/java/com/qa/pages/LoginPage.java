package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private WebElement usernamefield;
    private WebElement passwordfield;
    private WebElement loginBtb;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernamefield = this.driver.findElement(By.name("username"));
        passwordfield = this.driver.findElement(By.name("password"));
        loginBtb = this.driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void login() {

        usernamefield.sendKeys(System.getProperty("email"));
        passwordfield.sendKeys(System.getProperty("password"));
        loginBtb.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


