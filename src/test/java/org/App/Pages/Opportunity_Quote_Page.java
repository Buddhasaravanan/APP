package org.App.Pages;

import org.App.Factory.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class Opportunity_Quote_Page  extends Basepage
{

    Date d=new Date();


    public Opportunity_Quote_Page(WebDriver driver)
    {
        super(driver);

    }


        @FindBy(xpath = "//mat-list-item[@id='app-nav-opportunities']")
        private WebElement opportunities;

        @FindBy(xpath = "//button[@id='btn-new-opportunity']")
        private WebElement newOpportunity;

        @FindBy(xpath = "//input[@id='opportunityName']")
        private WebElement opportunityName;

        @FindBy(id = "opportunityProjectType")
        private WebElement selectProjectType;

        @FindBy(id = "buildingTypeId")
        private WebElement selectBulidingType;

        @FindBy(id = "marketSector")
        private WebElement selectMarketType;

        @FindBy(xpath = "//input[@placeholder='Client name']")
        private WebElement clientName;

        @FindBy(xpath = "//div[@id='btn-create-opportunity']")
        private WebElement next;

        @FindBy(xpath = "//input[@id='opportunityMeasurementLabel']")
        private WebElement squareFeet;

        @FindBy(id = "btn-create-opportunity")
        private WebElement create;

        @FindBy(xpath = "//span[contains(text(), 'Won')]")
        private WebElement wonbtn;

        @FindBy(xpath = "//span[contains(text(), 'Service')]")
        private WebElement service;

        @FindBy(xpath = "//span[contains(text(), 'Single Family Detached - Production')]")
        private WebElement markettypesingle;

        @FindBy(xpath = "//span[contains(text(), 'Residential')]")
        private WebElement residential;

        @FindBy(id = "opportunityBudget")
        private WebElement oppbudget;

        @FindBy(xpath = "//ng-select[@id=\"quoteType\"]")
        private WebElement quotetype;

        @FindBy(xpath = "//span[contains(text(), 'Bid/Spec')]")
        private WebElement bid;


        public void clickOpportunity() {
            clickWithWait(opportunities);
        }

        public void clickNewOpportunity() {
            clickWithWait(newOpportunity);
        }

        public void enterOpportunityName() throws IOException {
            sendKeysWithWait(opportunityName, Base.getProperties().getProperty("oppname") + " " + d);
        }

        public void selectProjectType() {
            try {
                clickWithWait(selectProjectType);
                clickWithWait(service);
            } catch (Exception e) {
                handleException("Error selecting project type", e);
            }
        }

        public void selectMarketType() {
            try {
                clickWithWait(selectMarketType);
                clickWithWait(markettypesingle);
            } catch (Exception e) {
                handleException("Error selecting market type", e);
            }
        }

        public void enterClientName() throws IOException {
            sendKeysWithWait(clientName, Base.getProperties().getProperty("Cname") + Keys.ENTER);
        }

        public void clickNextButton() {
            try {
                clickWithWait(next);
                //clickWithWait(next); // Second click if needed
            } catch (Exception e) {
                handleException("Error clicking next button", e);
            }
        }

        public void enterSquareFeet() throws IOException {
            sendKeysWithWait(squareFeet, Base.getProperties().getProperty("sqfeet"));
        }

        public void clickCreateOpportunity() {
            try {
                clickWithWait(create);
            } catch (Exception e) {
                handleException("Error creating opportunity", e);
            }
        }

        public boolean isOpportunityCreated() {
            return isElementDisplayed(wonbtn);
        }

        public void selectResidentialBuildingType() {
            try {
                clickWithWait(selectBulidingType);
                clickWithWait(residential);
            } catch (Exception e) {
                handleException("Error selecting building type", e);
            }
        }

        public void enterBudget() throws IOException {
            sendKeysWithWait(oppbudget, Base.getProperties().getProperty("Budget"));
        }

        public void selectQuoteType() {
            clickWithWait(quotetype);
            clickWithWait(bid);
        }

        // Helper methods
        private void clickWithWait(WebElement element) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .click();
        }

        private void sendKeysWithWait(WebElement element, String text) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element))
                    .sendKeys(text);
        }

        private boolean isElementDisplayed(WebElement element) {
            try {
                return new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOf(element))
                        .isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }

        private void handleException(String message, Exception e) {
            System.out.println(message + ": " + e.getMessage());
            throw new RuntimeException(message, e);
        }
    }





