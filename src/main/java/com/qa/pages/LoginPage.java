package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private WebElement usernamefield;
    private WebElement passwordfield;
    private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernamefield = this.driver.findElement(By.name("username"));
        passwordfield = this.driver.findElement(By.name("password"));
        loginBtn = this.driver.findElement(By.xpath("//button[@type='submit']"));

    }

    public void login() {

        usernamefield.sendKeys(System.getProperty("email"));
        passwordfield.sendKeys(System.getProperty("password"));
        loginBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void login(String username, String pass) {


        System.out.println(username);
        usernamefield.sendKeys(username);
        passwordfield.sendKeys(pass);
        loginBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public WebElement getInvalidAlertTxt() {
        return this.driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
    }

    public WebElement getAlertForEmptyUsername() {
        return this.driver.findElement(By.xpath("//span[text()='Required']"));


    }

    public boolean usenameIsDisplayed() {
        return usernamefield.isDisplayed();
    }

    public boolean passwordIsDisplayed() {
        return passwordfield.isDisplayed();
    }

    public boolean loginBtnIsDisplayed() {
        return loginBtn.isDisplayed();
    }


    public void sidePannel(String text) {

        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='oxd-sidepanel-body']/ul/li"));

        for (WebElement elemenet : ele) {
            if (elemenet.getText().equals(text)) {
                System.out.println( "Element : "+ elemenet.getText());
                elemenet.click();
                break;
            }
        }

    }

}


