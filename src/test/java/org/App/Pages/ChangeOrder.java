package org.App.Pages;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.App.Factory.Base;

public class ChangeOrder extends Basepage {

    private final WebDriverWait wait;
    private final Actions actions;

    public ChangeOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    @FindBy(id="nav-co") private WebElement changeOrderTab;
    @FindBy(xpath="//span[contains(text(), 'New change order')]") private WebElement newChangeOrderBtn;
    @FindBy(xpath="//input[@placeholder='Change order name']") private WebElement coNameField;
    @FindBy(xpath="//span[contains(text(), 'Create & open change order')]") private WebElement createCoBtn;
    @FindBy(xpath="(//div[contains(text(),'Overview')])[2]") private WebElement coOverviewHeader;
    @FindBy(id="nav-design") private WebElement designTab;
    @FindBy(xpath="(//div[@id='showHideColumns'])[1]") private WebElement firstItemHover;
    @FindBy(xpath="//span[contains(text(),'More')]") private WebElement moreOptionsMenu;
    @FindBy(xpath="//span[contains(text(),'Remove from change order')]") private WebElement removeItemOption;
    @FindBy(xpath="//label[contains(text(),'Keep the accessories')]") private WebElement keepAccessoriesOption;
    @FindBy(xpath="//span[contains(text(),'Yes, remove')]") private WebElement confirmRemoveBtn;
    @FindBy(xpath="//span[text()='Removed']") private WebElement removedStatusLabel;
    @FindBy(xpath="//mat-icon[@svgicon='copyContent']") private WebElement copyItemIcon;
    @FindBy(xpath="(//span[contains(text(),'All')])[2]") private WebElement allLocationsOption;
    @FindBy(xpath="(//span[contains(text(),'Copy')])[2]") private WebElement copyItemsBtn;
    @FindBy(xpath="//mat-icon[@svgicon='replace']") private WebElement replaceItemIcon;
    @FindBy(xpath="(//input[@id='add-product-search'])[2]") private WebElement itemSearchField;
    @FindBy(xpath="//div[@id='item_0']") private WebElement firstSearchResult;
    @FindBy(xpath="//span[contains(text(),'Select')]") private WebElement selectItemBtn;
    @FindBy(xpath="//span[contains(text(),'Maintain price')]") private WebElement maintainPriceOption;
    @FindBy(xpath="//span[contains(text(),'Keep labor')]") private WebElement keepLaborOption;
    @FindBy(id="btn-replace") private WebElement replaceBtn;
    @FindBy(xpath="//div[contains(text(),'Internal')]") private WebElement internalCoOption;
    @FindBy(xpath="//span[contains(text(),'Approve change order')]") private WebElement approveCoBtn;
    @FindBy(xpath="(//span[contains(text(),'Approve')])[2]") private WebElement confirmApproveBtn;
    @FindBy(xpath="(//mat-icon[@svgicon='backIcon'])[1]") private WebElement backButton;
    @FindBy(xpath="//div[@class='cdk-overlay-pane']") private WebElement toastMessage;


    public void navigateToChangeOrders() {
        clickWithWait(changeOrderTab);
    }

    public void createNewChangeOrder() {
        clickWithWait(newChangeOrderBtn);
    }

    public void enterChangeOrderName(String name) throws IOException {
        enterText(coNameField, Base.getProperties().getProperty("ExternalCOName"));
    }

    public void saveAndOpenChangeOrder() {
        clickWithWait(createCoBtn);
    }

    public boolean isChangeOrderCreated() {
        return isElementDisplayed(coOverviewHeader);
    }

    public void navigateToDesignSection() {
        clickWithWait(designTab);
    }

    public void hoverFirstItem() {
        hoverElement(firstItemHover);
    }

    public void removeItemKeepingAccessories() {
        clickWithWait(moreOptionsMenu);
        clickWithWait(removeItemOption);
        clickWithWait(keepAccessoriesOption);
        clickWithWait(confirmRemoveBtn);
    }

    public String getRemovedStatusText() {
        return getElementText(removedStatusLabel);
    }

    public void removeitemwithoutlabor()
    {
        clickWithWait(moreOptionsMenu);
        clickWithWait(removeItemOption);
        clickWithWait(keepLaborOption);
        clickWithWait(confirmRemoveBtn);
    }

    public void copyItemToAllLocations() {
        clickWithWait(copyItemIcon);
        clickWithWait(allLocationsOption);
        clickWithWait(copyItemsBtn);
    }

    public boolean verifyCopySuccess() {
        return verifyToastMessage("Items copied to locations");
    }

    public void createInternalChangeOrder(String coNameProperty) throws IOException {
        clickWithWait(newChangeOrderBtn);
        clickWithWait(internalCoOption);
        enterText(coNameField, Base.getProperties().getProperty("InternalCOName"));
        clickWithWait(createCoBtn);
    }

    public void replaceItem(String itemNameProperty) throws IOException {
        clickWithWait(replaceItemIcon);
        enterText(itemSearchField, Base.getProperties().getProperty("replaceitem"));
        clickWithWait(firstSearchResult);
        clickWithWait(selectItemBtn);
        clickWithWait(maintainPriceOption);
        clickWithWait(keepLaborOption);
        clickWithWait(replaceBtn);
    }

    public void approveChangeOrder() {
        clickWithWait(approveCoBtn);
        clickWithWait(confirmApproveBtn);
    }

    public void navigateBackFromCO() {
        clickWithWait(backButton);
    }

    // Helper
    private void clickWithWait(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    private void hoverElement(WebElement element) {
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(element))).perform();
    }

    private String getElementText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    private boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    private boolean verifyToastMessage(String expectedMessage) {
        try {
            String actualMessage = wait.until(ExpectedConditions.visibilityOf(toastMessage)).getText();
            return actualMessage.equals(expectedMessage);
        } catch (TimeoutException e) {
            return false;
        }
    }
}
