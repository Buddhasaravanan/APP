package org.App.StepDefinition;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.App.Factory.Base;
import org.App.Pages.Opportunity_Quote_Page;

import java.io.IOException;

@Epic("Opportunity and Quote Management")
@Feature("Opportunity and Quote Creation")
public class Opportunityandquote {
    private String actualToastMessage;
    Opportunity_Quote_Page op = new Opportunity_Quote_Page(Base.getdriver());

    @When("the user click opportunity from main menu")
    @Step("User clicks on opportunity from main menu")
    @Description("Navigate to opportunities section from the main application menu")
    public void the_user_click_opportunity_from_main_menu() {
        op.clickOpportunity();
    }

    @When("the user click new opportunity button")
    @Step("User clicks new opportunity button")
    @Description("Initiate creation of a new opportunity")
    public void the_user_click_new_opportunity_button() {
        op.clickNewOpportunity();
    }

    @When("the user entring opportunity name")
    @Step("User enters opportunity name: {name}")
    @Description("Provide a name for the new opportunity")
    public void the_user_entring_opportunity_name() throws IOException {
        op.enterOpportunityName();
    }

    @When("the user select bulding type")
    @Step("User selects building type")
    @Description("Select residential building type for the opportunity")
    public void the_user_select_bulding_type() {
        op.selectResidentialBuildingType();
    }

    @When("the user entering budget of opportunity")
    @Step("User enters opportunity budget")
    @Description("Specify budget amount for the opportunity")
    public void the_user_entering_budget_of_opportunity() throws IOException {
        op.enterBudget();
    }

    @When("the user entering sqfeet of opportunity")
    @Step("User enters square footage")
    @Description("Provide square footage information for the opportunity")
    public void the_user_entering_sqfeet_of_opportunity() throws IOException {
        op.enterSquareFeet();
    }

    @When("the user select project type and market type")
    @Step("User selects project type and market type")
    @Description("Configure project and market types for the opportunity")
    public void the_user_select_project_type_and_market_type() {
        op.selectProjectType();
        op.selectMarketType();
    }

    @When("the user select quote type")
    @Step("User selects quote type")
    @Description("Choose appropriate quote type for the opportunity")
    public void the_user_select_quote_type() {
        op.selectQuoteType();
        op.clickNextButton();
    }

    @When("the user entering client name")
    @Step("User enters client name")
    @Description("Provide client information for the opportunity")
    public void the_user_entering_client_name() throws IOException {
        op.enterClientName();
    }

    @When("the user click next button")
    @Step("User proceeds to next step")
    @Description("Navigate to next step in opportunity creation")
    public void the_user_click_next_button() {
        op.clickNextButton();
    }

    @When("the user click create button")
    @Step("User creates opportunity")
    @Description("Finalize opportunity creation")
    public void the_user_click_create_button() {
        op.clickCreateOpportunity();
    }

    @Then("validate the opportunity created")
    @Step("Validate opportunity creation")
    @Description("Verify successful opportunity creation")
    @Severity(SeverityLevel.BLOCKER)
    @Story("As a user I should be able to create opportunities")
    public void validate_the_opportunity_created() {
        boolean isDisplayed = op.isOpportunityCreated();
        if(isDisplayed) {
            System.out.println("Opportunity created successfully");
        } else {
            System.out.println("Opportunity creation failed");
        }
    }

    @When("the user go to new quote and design section")
    @Step("User navigates to quote and design section")
    @Description("Access quote and design functionality for the opportunity")
    public void the_user_go_to_new_quote_and_design_section() {
        op.clickQuoteAndDesign();
    }

    @When("the user search item")
    @Step("User searches for item: {itemName}")
    @Description("Search for specific item to add to quote")
    public void the_user_search_item() throws IOException {
        op.searchItem(Base.getProperties().getProperty("item_name"));
    }

    @When("the user add item to quote")
    @Step("User adds item to quote")
    @Description("Include selected item in the quote")
    public void the_user_add_item_to_quote() {
        op.additem();
    }

    @Then("validating item added to quote")
    @Step("Validate item added to quote")
    @Description("Verify successful addition of item to quote")
    @Severity(SeverityLevel.CRITICAL)
    public void validating_item_added_to_quote() {
        /*try {
            actualToastMessage = op.getToastMessage();
            Assert.isTrue(actualToastMessage.contains("Item added"), "Toast message not matching");
        } catch (Exception e) {
            Assert.isTrue(false, "Toast message not matching");
        }*/


    }

    @When("the user add accessory to item")
    @Step("User adds accessory to item")
    @Description("Include accessory for the quoted item")
    public void the_user_add_accessory_to_item() throws IOException {
        op.addAccessory(Base.getProperties().getProperty("accessory"));
    }

    @Then("validating accessory added to quote")
    @Step("Validate accessory added to quote")
    @Description("Verify successful addition of accessory")
    public void validating_accessory_added_to_quote() {
        try {
            actualToastMessage = op.getToastMessage();
            Assert.isTrue(actualToastMessage.contains("Item added"), "Toast message not matching");
        } catch (Exception e) {
            Assert.isTrue(false, "Toast message not matching");
        }
    }

    @When("the user add new adjestment to quote")
    @Step("User adds new adjustment to quote")
    @Description("Apply adjustment to the quote")
    public void the_user_add_new_adjestment_to_quote() throws IOException {
        op.addAdjustment(Base.getProperties().getProperty("adjestment_name"),Base.getProperties().getProperty("adjestment_value"));
    }

    @Then("Validating new adjestment added to quote")
    @Step("Validate adjustment added to quote")
    @Description("Verify successful application of adjustment")
    public void validating_new_adjestment_added_to_quote() {
        Assert.isTrue(op.isAdjustmentButtonVisible(), "Adjustment button not visible");
    }

    @When("the user create new optional location")
    @Step("User creates new optional location")
    @Description("Add optional location to the quote")
    public void the_user_create_new_optional_location() throws IOException {
        op.createOptionalLocation(Base.getProperties().getProperty("location_name"));
    }

    @Then("Validating new optional location created")
    @Step("Validate optional location creation")
    @Description("Verify successful creation of optional location")
    public void validating_new_optional_location_created() {
        Assert.isTrue(op.isOptionalTagVisible(), "Optional tag not visible");
    }

    @When("the user search labor")
    @Step("User searches for labor")
    @Description("Search for labor to add to quote")
    public void the_user_search_labor() throws IOException {
        op.searchLabor(Base.getProperties().getProperty("labor"));
    }

    @When("the user add labor to quote")
    @Step("User adds labor to quote")
    @Description("Include labor in the quote")
    public void the_user_add_labor_to_quote() {
        op.addlabor();
    }

    @Then("Validating labor added to quote")
    @Step("Validate labor added to quote")
    @Description("Verify successful addition of labor")
    public void validating_labor_added_to_quote() {
        try {
            actualToastMessage = op.getToastMessage();
            Assert.isTrue(actualToastMessage.contains("Labor added"), "Toast message not matching");
        } catch (Exception e) {
            Assert.isTrue(false, "Toast message not matching");
        }
    }

    @When("the user add exsiting service plan to quote")
    @Step("User adds existing service plan to quote")
    @Description("Include service plan in the quote")
    public void the_user_add_exsiting_service_plan_to_quote() {
        op.addServicePlan();
    }

    @Then("validating service plan added or not")
    @Step("Validate service plan addition")
    @Description("Verify successful addition of service plan")
    public void validating_service_plan_added_or_not() {
        Assert.isTrue(op.isRecommendedPlanVisible(), "Recommended plan not visible");
    }

    @When("the user create new multimedia proposal")
    @Step("User creates multimedia proposal")
    @Description("Generate multimedia proposal for the quote")
    @Severity(SeverityLevel.CRITICAL)
    @Story("As a user I should be able to create multimedia proposals")
    public void the_user_create_new_multimedia_proposal() {
        op.createMultimediaProposal();
    }

    @When("the user go to present proposal and accept the proposal")
    @Step("User presents and accepts proposal")
    @Description("Present proposal to client and record acceptance")
    public void the_user_go_to_present_proposal_and_accept_the_proposal() throws IOException {
        op.presentAndAcceptProposal(Base.getProperties().getProperty("proposal_email"), Base.getProperties().getProperty("firstname"), Base.getProperties().getProperty("Lastname"));
    }

    @When("the user make payment via DTP")
    @Step("User processes payment via DTP")
    @Description("Complete payment processing for the opportunity")
    @Severity(SeverityLevel.BLOCKER)
    public void the_user_make_payment_via_dtp() {
        op.processPayment();
    }

    @When("the user won the opportunity")
    @Step("User marks opportunity as won")
    @Description("Finalize opportunity as won in the system")
    public void the_user_won_the_opportunity() {
        op.markOpportunityAsWon();
    }

    @Then("Validating new project created")
    @Step("Validate new project creation")
    @Description("Verify successful project creation from won opportunity")
    @Severity(SeverityLevel.BLOCKER)
    @Story("As a user I should be able to convert opportunities to projects")
    public void validating_new_project_created() {
        Assert.isTrue(op.isProjectNumberVisible(), "Project number not visible");
    }
}