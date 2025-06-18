package org.App.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;

import org.App.Factory.Base;
import org.App.Pages.Loginpage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

@Epic("User Authentication")
@Feature("Login Functionality")
public class Login {

    @Given("the user should be navigate to login page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Navigates to the login page using Base class browser initialization")
    @Step("Navigate to login page")
    public void the_user_should_be_navigate_to_login_page() throws IOException, InterruptedException {
        Base.initilizebrowser();
    }

    @When("the user entering invalid login credentials")
    @Severity(SeverityLevel.NORMAL)
    @Description("Enter invalid email and password from config")
    @Step("Enter invalid login credentials")
    public void the_user_entering_invalid_login_credentials() throws IOException {
        Loginpage lp = new Loginpage(Base.getdriver());
        lp.enterCredentials(Base.getProperties().getProperty("email"), Base.getProperties().getProperty("pwd"));
    }

    @When("the user click sign in button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Click the login button on the login page")
    @Step("Click sign-in button")
    public void the_user_click_sign_in_button() {
        Loginpage lp = new Loginpage(Base.getdriver());
        lp.clickLogin();
    }

    @Then("the user got password wrong message")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the error message for incorrect password")
    @Step("Check invalid login message")
    public void the_user_got_password_wrong_message() {
        Loginpage lp = new Loginpage(Base.getdriver());
        boolean isDisplayed = lp.isInvalidLoginMessageDisplayed();
        if (isDisplayed) {
            System.out.println("Invalid login credentials");
        } else {
            System.out.println("Valid login credentials");
        }
    }

    @When("the user entering valid login credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enter valid email and password from config")
    @Step("Enter valid login credentials")
    public void the_user_entering_valid_login_credentials() throws IOException {
        Loginpage lp = new Loginpage(Base.getdriver());
        lp.enterCredentials(Base.getProperties().getProperty("email"), Base.getProperties().getProperty("pwd"));
    }

    @When("the user select the company")
    @Severity(SeverityLevel.NORMAL)
    @Description("User selects the company and closes any popup")
    @Step("Select company and close popup")
    public void the_user_select_the_company() {
        Loginpage lp = new Loginpage(Base.getdriver());
        lp.selectCompany();
        lp.closePopup();
    }

    @Then("the user should navigate to dashboard page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that dashboard page is displayed after login")
    @Step("Verify dashboard page is displayed")
    public void the_user_should_navigate_to_dashboard_page() {
        Loginpage lp = new Loginpage(Base.getdriver());
        new WebDriverWait(Base.getdriver(), Duration.ofSeconds(30)).until(wd -> lp.isDashboardDisplayed());
        System.out.println("Login successful");
    }
}
