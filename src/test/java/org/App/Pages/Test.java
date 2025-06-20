package org.App.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test  extends Basepage
{
    private final WebDriverWait wait;

    public Test(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(id = "app-nav-catalog") public static WebElement Navicatalog ;

    @FindBy(xpath = "//div[contains(text(),'My Products')]") public static WebElement NavigaMYproducts ;

    @FindBy(xpath = "//div[contains(text(),'Subscriptions')]") public static WebElement NaviSubscriptions ;

    @FindBy(id = "txt-app-search") public static WebElement Search_BTN ;

    @FindBy(xpath = "//span[contains(text(), '00 Automation ajay3456')]") public static WebElement Clickproducts ;

    @FindBy(xpath = "(//span[contains(text(),'Equipment')])[2]") public static WebElement ClickEquipment ;

    @FindBy(xpath = "(//span[contains(text(),'Subscription')])[2]") public static WebElement ClickSubscriptions_BTN ;

    @FindBy(xpath = "(//span[@class='ng-arrow-wrapper']/span[@class='ng-arrow'])[8]") public static WebElement Click_dropBTN ;


    @FindBy(xpath = "//span[contains(text(), 'Month')]") public static WebElement month1 ;





    public void catalog()
    {
        clickWithWait(Navicatalog);
        clickWithWait(NavigaMYproducts);
        clickWithWait(Clickproducts);
        clickWithWait(ClickEquipment);
        clickWithWait(ClickSubscriptions_BTN);
        clickWithWait(month1);
    }

    private void clickWithWait(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }



}
