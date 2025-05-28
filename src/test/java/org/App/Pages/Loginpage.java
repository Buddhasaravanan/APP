package org.App.Pages;

import org.App.Factory.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage
{
    WebDriver driver;


    public Loginpage(WebDriver driver)
    {
        super(driver);

    }


    @FindBy(id="email")
    WebElement username;
    @FindBy(id="password") WebElement password;
    @FindBy(id="next") WebElement login;
    @FindBy(xpath="//span[contains (text(), 'D-Tools - DND')]") WebElement company;
    @FindBy(xpath="//button[contains (text(), 'OK')]") WebElement popup;
    @FindBy(xpath="//label[contains (text(), 'Dashboard')]") WebElement dashboardtxt;
    @FindBy(xpath="//span[contains (text(), 'Skip, will do later')]") WebElement mfa;
    @FindBy(xpath="//h3[contains (text(), 'Secure your account using MFA')]") WebElement mfatext;
    @FindBy(xpath="//span[contains (text(), ' D-tools DND - QBO')]") WebElement devcompany;
    @FindBy(xpath="//div[@class='error pageLevel']") WebElement invalidloginmessage;


    //New Signup
    @FindBy(id="createAccount") WebElement newsignup;
    @FindBy(id="givenName") WebElement firstname;
    @FindBy(id="surname") WebElement secondnaem;
    @FindBy(id="email") WebElement emailadderss;
    @FindBy(id="newPassword") WebElement newpasword;
    @FindBy(id="reenterPassword") WebElement repassword;
    @FindBy(id="btnNext") WebElement continuebtn;

    @FindBy(xpath="//button[contains (text(), 'OK')]")  WebElement cacshpopup;


    public void enterCredentials(String email, String pwd)
    {
        username.sendKeys(email);
        password.sendKeys(pwd);

    }

    public void clickLogin() {
        login.click();
    }

    public void selectCompany() {
        try {
            if (Base.getdriver().getCurrentUrl().contains("dev")) {
                mfa.click();
                Thread.sleep(2000); // Consider using explicit wait instead
                devcompany.click();
            } else {
                company.click();
            }
        } catch (Exception e) {
            System.out.println("Error selecting company: " + e.getMessage());
        }
    }

    public void closePopup() {
        popup.click();
    }

    public boolean isDashboardDisplayed() {
        return dashboardtxt.isDisplayed();
    }


    public boolean isInvalidLoginMessageDisplayed() {
        return invalidloginmessage.isDisplayed();
    }









}
