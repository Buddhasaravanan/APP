package org.App.Pages;

import org.App.Factory.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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
    private WebDriverWait wait;


    public Opportunity_Quote_Page(WebDriver driver)
    {
        super(driver);

        this.wait = new WebDriverWait(Base.getdriver(), Duration.ofSeconds(30));

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

        @FindBy(xpath = "(//span[contains(text(), 'Service')])[2]")
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

    @FindBy(xpath = "//div[@class='q-name']")
    private WebElement quote;

    @FindBy(xpath = "//div[@id='nav-design']")
    private WebElement design;

    // Search elements
    @FindBy(xpath = "//input[@id='add-product-search']")
    private WebElement itemSearch;

    @FindBy(xpath = "//div[@id='item_0']")
    private WebElement firstItem;

    @FindBy(xpath = "//span[contains(text(),'Add to quote')]")
    private WebElement addToQuote;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane']")
    private WebElement toastMsg;

    // Adjustment elements
    @FindBy(xpath = "(//div[@class='more-menu'])[1]")
    private WebElement moreMenu;

    @FindBy(xpath = "//span[contains(text(),'Adjustments')]")
    private WebElement adjustment;

    @FindBy(xpath = "//span[contains(text(), 'Add adjustment')]")
    private WebElement addAdjustmentBtn;

    @FindBy(xpath = "//input[@placeholder='Adjustment name']")
    private WebElement adjustmentName;

    @FindBy(id = "adjustment-dollar-percent-toggle")
    private WebElement percentToggle;

    @FindBy(id = "adjustment-amount")
    private WebElement adjustmentAmount;

    @FindBy(xpath = "(//span[contains(text(), 'Add')])[4]")
    private WebElement addAdjustment;

    @FindBy(xpath = "(//mat-icon[@svgicon='closeIcon'])[4]")
    private WebElement adjustmentCloseIcon;

    // Location elements
    @FindBy(xpath = "//a[text()='+ New location']")
    private WebElement createNewLocation;

    @FindBy(xpath = "//input[@placeholder='Location name']")
    private WebElement locationName;

    @FindBy(id = "optional-locOrSys-button")
    private WebElement optionalLocationToggle;

    @FindBy(xpath = "//div[contains(text(),'Create')]")
    private WebElement locCreate;

    @FindBy(xpath = "//span[contains(text(), 'optional')]")
    private WebElement optionalTag;

    // Proposal elements
    @FindBy(id = "quote-summary-menu")
    private WebElement quotePriceSummary;

    @FindBy(xpath = "//span[contains(text(), 'Create proposal')]")
    private WebElement createProposalBtn;

    @FindBy(id = "itemDisplay")
    private WebElement itemDisplay;

    // Accessory elements
    @FindBy(xpath = "//mat-icon[@svgicon='addAccessory']")
    private WebElement addAccessory;

    @FindBy(xpath = "(//span[contains(text(), 'Add')])[3]")
    private WebElement addAccessoryBtn;

    @FindBy(xpath = "(//input[@id='add-product-search'])[2]")
    private WebElement accessoriesSearch;

    // Multimedia proposal elements
    @FindBy(xpath = "//mat-icon[@svgicon='multimedia-proposal']")
    private WebElement multimediaProposal;

    @FindBy(xpath = "//div[contains(text(), 'Quick Quote')]")
    private WebElement quickQuoteProposal;

    @FindBy(xpath = "//span[text()='Create']")
    private WebElement createBtn;

    // Payment elements
    @FindBy(id = "present-proposal")
    private WebElement presentProposal;

    @FindBy(xpath = "//span[contains(text(),'Accept & Pay')]")
    private WebElement acceptAndSignBtn;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='First name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last name']")
    private WebElement lastName;

    @FindBy(xpath = "//span[contains(text(), 'Accept & Proceed to Payment')]")
    private WebElement acceptProposal;

    @FindBy(xpath = "//span[contains(text(),'Return to proposal')]")
    private WebElement returnProposal;

    @FindBy(xpath = "//mat-icon[@svgicon='backIcon']")
    private WebElement proposalBackBtn;

    @FindBy(xpath = "//mat-icon[@svgicon='closeIcon']")
    private WebElement proposalCloseBtn;

    // Project elements
    @FindBy(xpath = "//span[normalize-space()='Won']")
    private WebElement wonBtn;

    @FindBy(xpath = "//span[normalize-space()='Create project']")
    private WebElement createProject;

    @FindBy(id = "projectNumber")
    private WebElement projectNumber;

    // Service plan elements
    @FindBy(id = "nav-service-plan-list-design")
    private WebElement servicePlan;

    @FindBy(id = "btn-quote-service-plan-add")
    private WebElement addServicePlan;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement april13;

    @FindBy(xpath = "//span[contains(text(), 'Monitoring Agreements')]")
    private WebElement monitoringAgreement;

    @FindBy(xpath = "(//span[contains(text(), 'Add')])[3]")
    private WebElement serviceAdd;

    @FindBy(xpath = "//span[contains(text(), 'Service Agreements')]")
    private WebElement recommendedPlan;

    @FindBy(xpath = "//h1[contains (text(),'This is embarrassing...')]")
    private WebElement crash;

    @FindBy(xpath = "//span[contains (text(),'Try again')]")
    private WebElement tryagain;




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

                if(wonBtn.isDisplayed())
                {
                    System.out.println("No Crash occurs");
                }
                else
                {
                    clickWithWait(tryagain);
                    System.out.println("BUG: Crash occurs");
                }
            } catch (Exception e) {
                handleException("Error creating opportunity", e);
            }
        }

        public boolean isOpportunityCreated() {
            return isElementDisplayed(wonBtn);
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

    public void clickQuoteAndDesign() {
        clickElement(quote);
        clickElement(design);
    }

    public void searchItem(String itemName) {
        sendKeysWithWait(itemSearch, itemName);
        clickElement(firstItem);

    }

    public void additem()
    {
        clickElement(addToQuote);
    }

    public String getToastMessage()
    {
        try
        {
            WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMsg));
            return toast.getText();
        }
        catch (TimeoutException e)
        {
            throw new RuntimeException("Toast message did not appear within timeout period");
        }
                //return waitForElement(toastMsg).getText();
    }

    public void addAdjustment(String name, String value) {
        clickElement(moreMenu);
        clickElement(adjustment);
        clickElement(addAdjustmentBtn);
        sendKeysWithWait(adjustmentName, name);
        clickElement(percentToggle);
        clearAndSendKeys(adjustmentAmount, value);
        clickElement(addAdjustment);
        clickElement(adjustmentCloseIcon);
    }

    public boolean isAdjustmentButtonVisible() {
        return addAdjustmentBtn.isDisplayed();
    }

    public void createOptionalLocation(String locationName) {
        clickElement(createNewLocation);
        sendKeysWithWait(this.locationName, locationName);
        clickElement(optionalLocationToggle);
        clickElement(locCreate);
    }

    public boolean isOptionalTagVisible() {
        return optionalTag.isDisplayed();
    }

    public void searchLabor(String laborName) {
        sendKeysWithWait(itemSearch, laborName);
        clickElement(firstItem);

    }

    public void addlabor()
    {
        clickElement(addToQuote);
    }


    public void addAccessory(String accessoryName) {
        clickElement(itemDisplay);
        clickElement(addAccessory);
        sendKeysWithWait(accessoriesSearch, accessoryName);
        clickElement(firstItem);
        clickElement(addAccessoryBtn);
    }

    public void createMultimediaProposal() {
        clickElement(createProposalBtn);
        clickElement(multimediaProposal);
        clickElement(createBtn);
    }

    public void presentAndAcceptProposal(String email, String firstName, String lastName) {
        clickElement(presentProposal);
        clickElement(acceptAndSignBtn);

        if (!acceptProposal.isSelected()) {
            sendKeysWithWait(this.email, email);
            sendKeysWithWait(this.firstName, firstName);
            sendKeysWithWait(this.lastName, lastName);
        }
        clickElement(acceptProposal);
    }

    public void processPayment() {
        clickElement(proposalCloseBtn);
        clickElement(proposalBackBtn);
        clickElement(proposalBackBtn);
        clickElement(proposalBackBtn);
    }

    public void markOpportunityAsWon() {
        clickElement(wonBtn);
        clickElement(createProject);
    }

    public boolean isProjectNumberVisible() {
        return projectNumber.isDisplayed();
    }

    public void addServicePlan() {
        clickElement(servicePlan);
        clickElement(addServicePlan);
        clickElement(april13);
        clickElement(monitoringAgreement);
        clickElement(april13);
        clickElement(serviceAdd);
    }

    public boolean isRecommendedPlanVisible() {
        return recommendedPlan.isDisplayed();
    }

    // Helper methods
    private void clickElement(WebElement element) {
        waitForElement(element).click();
    }

    /*private void sendKeysWithWait(WebElement element, String text) {
        WebElement e = waitForElement(element);
        e.clear();
        e.sendKeys(text);
    }*/

    private void clearAndSendKeys(WebElement element, String text) {
        WebElement e = waitForElement(element);
        e.clear();
        e.sendKeys(text);
    }

    private WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}










