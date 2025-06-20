package org.App.StepDefinition;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.App.Factory.Base;
import org.App.Pages.ChangeOrder;
import org.App.Pages.Opportunity_Quote_Page;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.util.Arrays;

public class Change_Order extends Base
{
    private String actualToastMessage;
    private byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) Base.getdriver()).getScreenshotAs(OutputType.BYTES);
    }

    ChangeOrder co = new ChangeOrder(Base.getdriver());
    Opportunity_Quote_Page op = new Opportunity_Quote_Page(Base.getdriver());

    @When("user navigate change order")
    public void user_navigate_change_order()
    {
        co.navigateToChangeOrders();
    }
    @When("user click new change order button")
    public void user_click_new_change_order_button()
    {
        co.createNewChangeOrder();
    }
    @When("user select external co and giving a name")
    public void user_select_external_co_and_giving_a_name() throws IOException
    {
        co.enterChangeOrderName("name");
    }
    @When("user click create and open change order")
    public void user_click_create_and_open_change_order()
    {
        co.saveAndOpenChangeOrder();
    }
    @Then("Validate new CO created")
    public void validate_new_co_created()
    {
        try {
            boolean isCreated = co.isChangeOrderCreated();

            Allure.addAttachment("Change Order Status",
                    "text/plain",
                    "Change Order Created: " + isCreated);

            if (isCreated) {
                Allure.addAttachment("Success Screenshot", "image/png",
                        Arrays.toString(takeScreenshotAsBytes()));
            } else {
                takeScreenshotAsBytes();
                Assertions.fail("Change Order creation failed - Overview header not visible");
            }
        } catch (Exception e) {
            takeScreenshotAsBytes();
            Allure.addAttachment("Failure Details", "text/plain",
                    "Validation failed: " + e.getMessage());
            throw new AssertionError("Change Order validation error", e);
        }
    }
    @When("user go to new co and select design section")
    public void user_go_to_new_co_and_select_design_section()
    {
        co.navigateToDesignSection();
    }
    @When("user remove original item with keep accessory")
    public void user_remove_original_item_with_keep_accessory()
    {
        co.removeItemKeepingAccessories();
    }
    @Then("Validate item removed and keep accessory")
    public void validate_item_removed_and_keep_accessory( String Removed )
    {
        try {
            String actualStatus = co.getRemovedStatusText();

            Allure.addAttachment("Status Validation",
                    "text/plain",
                    "Expected: " + Removed + "\n" +
                            "Actual: " + actualStatus);

            Assertions.assertEquals("Removed status text mismatch",
                    Removed,
                    actualStatus);

        } catch (Exception e) {
            Allure.addAttachment("Failure Details", "text/plain",
                    "Status validation failed: " + e.getMessage());
            throw new AssertionError("Failed to validate removed status", e);
        }
    }
    @When("user remove original item keep labor")
    public void user_remove_original_item_keep_labor()
    {
       co.removeitemwithoutlabor();
    }
    @Then("Validate keep labor")
    public void validate_keep_labor()
    {

    }
    @When("user add item to change order")
    public void user_add_item_to_change_order()
    {
        op.searchItem("coitem");
        op.additem();
    }
    @Then("Validate add item to CO")
    public void validate_add_item_to_co()
    {
        try {
            actualToastMessage = op.getToastMessage();
            Assert.isTrue(actualToastMessage.contains("Item added"), "Toast message not matching");
        } catch (Exception e) {
            Assert.isTrue(false, "Toast message not matching");
        }
    }
    @When("user copy item to all location")
    public void user_copy_item_to_all_location()
    {
        co.copyItemToAllLocations();
    }
    @Then("Validate copy item")
    public void validate_copy_item()
    {
        try {
            boolean actualStatus = co.verifyCopySuccess();

            Allure.addAttachment("Status Validation",
                    "text/plain",
                    "Expected: " + "Items copied to locations" + "\n" +
                            "Actual: " + actualStatus);

            Assertions.assertEquals("Copy items status text mismatch",
                    "Items copied to locations",
                    String.valueOf(actualStatus));

        } catch (Exception e) {
            Allure.addAttachment("Failure Details", "text/plain",
                    "Status validation failed: " + e.getMessage());
            throw new AssertionError("Failed to validate removed status", e);
        }
    }
    @When("user replace the item")
    public void user_replace_the_item() throws IOException
    {
       co.replaceItem("replaceitem");
    }
    @Then("Validate replace item")
    public void validate_replace_item()
    {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user create proposal")
    public void user_create_proposal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Validate proposal created")
    public void validate_proposal_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user accept the change order")
    public void user_accept_the_change_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Validate accepted CO")
    public void validate_accepted_co() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user select internal co and giving a name")
    public void user_select_internal_co_and_giving_a_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Validate new internal CO created")
    public void validate_new_internal_co_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user add item")
    public void user_add_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Validate item added to CO")
    public void validate_item_added_to_co() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user approve the internal CO")
    public void user_approve_the_internal_co() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user back to CO dashboard")
    public void user_back_to_co_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
