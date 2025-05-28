package org.App.StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.App.Factory.Base;
import org.App.Pages.Opportunity_Quote_Page;

import java.io.IOException;

public class Opportunityandquote
{
    Opportunity_Quote_Page op = new Opportunity_Quote_Page(Base.getdriver());

    @When("the user click opportunity from main menu")
    public void the_user_click_opportunity_from_main_menu()
    {
        op.clickOpportunity();
    }

    @When("the user click new opportunity button")
    public void the_user_click_new_opportunity_button()
    {
        op.clickNewOpportunity();
    }

    @When("the user entring opportunity name")
    public void the_user_entring_opportunity_name() throws IOException
    {
        op.enterOpportunityName();
    }

    @When("the user select bulding type")
    public void the_user_select_bulding_type()
    {
        op.selectResidentialBuildingType();
    }

    @When("the user entering budget of opportunity")
    public void the_user_entering_budget_of_opportunity() throws IOException
    {
        op.enterBudget();
    }

    @When("the user entering sqfeet of opportunity")
    public void the_user_entering_sqfeet_of_opportunity() throws IOException
    {
        op.enterSquareFeet();
    }

    @When("the user select project type and market type")
    public void the_user_select_project_type_and_market_type()
    {
        op.selectProjectType();
        op.selectMarketType();
    }

    @When("the user select quote type")
    public void the_user_select_quote_type()
    {
        op.selectQuoteType();
        op.clickNextButton();
    }

    @When("the user entering client name")
    public void the_user_entering_client_name() throws IOException
    {
       op.enterClientName();
    }

    @When("the user click next button")
    public void the_user_click_next_button()
    {
        op.clickNextButton();
    }

    @When("the user click create button")
    public void the_user_click_create_button()
    {
        op.clickCreateOpportunity();
    }

    @Then("validate the opportunity created")
    public void validate_the_opportunity_created()
    {
        boolean isDisplayed = op.isOpportunityCreated();
        if(isDisplayed)
        {
            System.out.println("Opportunity created successfully");
        }
        else
        {
            System.out.println("Opportunity creation failed");
        }
    }

    @When("the user go to new quote and design section")
    public void the_user_go_to_new_quote_and_design_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user search item")
    public void the_user_search_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user add item to quote")
    public void the_user_add_item_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validating item added to quote")
    public void validating_item_added_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user add accessory to item")
    public void the_user_add_accessory_to_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validating accessory added to quote")
    public void validating_accessory_added_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user add new adjestment to quote")
    public void the_user_add_new_adjestment_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validating new adjestment added to quote")
    public void validating_new_adjestment_added_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user create new optional location")
    public void the_user_create_new_optional_location() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validating new optional location created")
    public void validating_new_optional_location_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user search labor")
    public void the_user_search_labor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user add labor to quote")
    public void the_user_add_labor_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validating labor added to quote")
    public void validating_labor_added_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user add exsiting service plan to quote")
    public void the_user_add_exsiting_service_plan_to_quote() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validating service plan added or not")
    public void validating_service_plan_added_or_not() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user create new multimedia proposal")
    public void the_user_create_new_multimedia_proposal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user go to present proposal and accept the proposal")
    public void the_user_go_to_present_proposal_and_accept_the_proposal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user make payment via DTP")
    public void the_user_make_payment_via_dtp() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user won the opportunity")
    public void the_user_won_the_opportunity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validating new project created")
    public void validating_new_project_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
