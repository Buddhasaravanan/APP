package org.App.StepDefinition;

import io.cucumber.java.en.When;
import org.App.Factory.Base;
import org.App.Pages.Test;
import org.openqa.selenium.WebDriver;


public class Tests
{
   Test t =  new Test(Base.getdriver());
    @When("user navigate catalog and make subscription")
    public void user_navigate_catalog_and_make_subscription()
    {
        t.catalog();
    }
}
