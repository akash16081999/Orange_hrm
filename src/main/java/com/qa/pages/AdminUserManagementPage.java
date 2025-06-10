package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminUserManagementPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addUserBtn;
    @FindBy(xpath = "//label[text()='User Role']//following::div[4]")
    private WebElement userRoleDrpdwnSelectBtn;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeenamefield;
    @FindBy(xpath = "//label[text()='Status']//following::div[4]")
    private WebElement statusField;
    @FindBy(xpath = "//label[text()='Username']//following::input[1]")
    private WebElement usernameField;
    @FindBy(xpath = "//label[text()='Confirm Password']//following::input[1]")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//label[text()='Password']//following::input[1]")
    private WebElement paswordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement adduserSubmitbtn;
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    private WebElement deletepopupBtn;


    private List<WebElement> userSuggestionlistdrpdwn;

    public AdminUserManagementPage(WebDriver drive) {
        this.driver = drive;
//        addUserBtn = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
//        userRoleDrpdwnSelectBtn = driver.findElement(By.xpath("//label[text()='User Role']//following::div[4]"));
//        employeenamefield = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        PageFactory.initElements(driver, this);
    }


    private void userRoleDropdownList(String userrole) {
        List<WebElement> elem = driver.findElements(By.xpath("//label[text()='User Role']//following::div[6]/div"));

        for (WebElement ele : elem) {
            if (ele.getText().equals(userrole)) {
                ele.click();
                break;
            }
        }
    }

    private void employeeSuggestionList() {

        int count = 0;
        userSuggestionlistdrpdwn = driver.findElements(By.xpath("//input[@placeholder='Type for hints...']//following::div"));

        for (WebElement webElement : userSuggestionlistdrpdwn) {

            if (webElement.getText().contains("Ravi M B")) {

                webElement.click();
                break;
            }

        }

    }

    private void statusDropdownlist() {
        List<WebElement> ele = driver.findElements(By.xpath("//label[text()='Status']//following::div[6]/div"));
        for (WebElement elem : ele) {
            if (elem.getText().equals("Enabled")) {
                elem.click();
                break;
            }
        }
    }

    public void addUser() {
        PageManager.getPageManagerObj().getLoginpageObject().login();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PageManager.getPageManagerObj().getLoginpageObject().sidePannel("Admin");
        addUserBtn.click();
        userRoleDrpdwnSelectBtn.click();
        userRoleDropdownList("Admin");

        employeenamefield.click();
        employeenamefield.sendKeys("Ravi M B");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        employeeSuggestionList();
        usernameField.click();
        usernameField.sendKeys("Akash");
        paswordField.click();
        paswordField.sendKeys("Testuser@123");
        confirmPasswordField.click();
        confirmPasswordField.sendKeys("Testuser@123");
        statusField.click();
        statusDropdownlist();
        adduserSubmitbtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().refresh();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // deleteUserFromAdminUserManagement("Akash");

    }

    public void deleteUserFromAdminUserManagement(String user) {

        List<WebElement> userRec = driver.findElements(By.xpath("//div[@class='orangehrm-container']/div/div[2]/div"));
        for (int i = 0; i < userRec.size(); i++) {

            if (userRec.get(i).getText().contains(user)) {
                System.out.println("MATCHED");
                int one = i + 1;
                driver.findElement(By.xpath("(//div[@class='orangehrm-container']/div/div[2]/div[" + one + "]//i[@class='oxd-icon bi-trash'])")).click();
                // System.out.println("//div[@class='orangehrm-container']/div/div[2]/div[" +one+"]//i[@class='oxd-icon bi-pencil-fill'])");
                deletepopupBtn.click();
                break;
            }
        }
    }

    public boolean userRecordsList(String username) {
        List<WebElement> userRec = driver.findElements(By.xpath("//div[@class='orangehrm-container']/div/div[2]/div"));
        for (WebElement webElement : userRec) {

            if (webElement.isDisplayed()) {
                return true;
            }
            break;
        }
        return false;
    }

}




