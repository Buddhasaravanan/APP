package org.App.Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {

    private final WebDriver driver;

    // Locators
    @FindBy(id="email")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="next")
    private WebElement loginButton;

    @FindBy(xpath="//span[contains(text(), 'D-Tools - DND')]")
    private WebElement company;

    @FindBy(xpath="//button[contains(text(), 'OK')]")
    private WebElement cashPopup;

    @FindBy(xpath="//label[contains(text(), 'Dashboard')]")
    private WebElement dashboardText;

    @FindBy(xpath="//span[contains(text(), 'Skip, will do later')]")
    private WebElement mfaSkip;

    @FindBy(xpath="//span[contains(text(), ' D-tools DND - QBO')]")
    private WebElement devCompany;

    @FindBy(xpath="//div[@class='error pageLevel']")
    private WebElement invalidloginmessage;


    // Constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login actions
    public void enterCredentials(String email, String pwd) {
        username.sendKeys(email);
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void selectCompany() {
        try {
            if (driver.getCurrentUrl().contains("dev")) {
                mfaSkip.click();
                Thread.sleep(2000); // Consider using explicit wait instead
                devCompany.click();
            } else {
                company.click();
            }
        } catch (Exception e) {
            System.out.println("Error selecting company: " + e.getMessage());
        }
    }

    public void closePopup() {
        cashPopup.click();
    }

    public boolean isDashboardDisplayed() {
        return dashboardText.isDisplayed();
    }

    public boolean isInvalidLoginMessageDisplayed() {
        return invalidloginmessage.isDisplayed();
    }

    // Helper method to perform complete login
  /*  public void performLogin(String email, String pwd) {
        enterCredentials(email, pwd);
        clickLogin();
        selectCompany();
        closePopup();
    }*/
}

