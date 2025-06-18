package org.App.StepDefinition;


import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import org.App.Factory.Base;
import org.App.Pages.Project_Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Project Management")
@Feature("Project Management")
public class Project
{

    private byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) Base.getdriver()).getScreenshotAs(OutputType.BYTES);
    }

    Project_Page pp = new Project_Page(Base.getdriver());

    @When("the user go to plan section")
    @Severity(SeverityLevel.NORMAL)
    @Step("User navigates to plan section")
    @Description("Navigate to plan section from the main application menu")
    public void the_user_go_to_plan_section()
    {
        pp.navigateToPlan();
    }
    @When("the user navigate to task page")
    @Severity(SeverityLevel.NORMAL)
    @Step("User navigates to task page")
    @Description("Navigate to task page from the main application menu")
    public void the_user_navigate_to_task_page()
    {
        pp.navigateToTasks();
    }
    @When("the user create task")
    @Severity(SeverityLevel.NORMAL)
    @Step("User creates a new task")
    @Description("Create a new task from the task page")
    public void the_user_create_task() throws IOException
    {
        pp.createNewTask();
    }
    @Then("validate task has been created")
    @Step("Validate task creation")
    @Severity(SeverityLevel.CRITICAL)
    public byte[] validate_task_has_been_created() throws IOException
    {
        try {
            boolean isTaskCreated = pp.validateTaskCreation();
            assertTrue(isTaskCreated, "Task creation failed - Schedule button not visible");

            Allure.addAttachment("Task Creation Status", "text/plain",
                    "Task created successfully at: " + new Date());
        } catch (Exception e) {
            takeScreenshotAsBytes();
            /*Allure.addAttachment("Failure Screenshot", "image/png",
                    new ByteArrayInputStream(takeScreenshotAsBytes()));*/
            throw new AssertionError("Task creation validation failed: " + e.getMessage());
        }

        return takeScreenshotAsBytes();
    }

    @When("the user create new task group")
    @Severity(SeverityLevel.NORMAL)
    @Step("User creates a new task group")
    @Description("Create a new task group from the task page")
    public void the_user_create_new_task_group() throws IOException
    {
        pp.createNewTaskGroup();
    }
    @Then("validate task group has been created")
    @Step("Verify toast message: {expectedMessage}")
    @Severity(SeverityLevel.NORMAL)
    public void validate_task_group_has_been_created(String expectedMessage)
    {
        try {
            String actualMessage = pp.getToastMessage();
            Allure.addAttachment("Toast Message",
                    "text/plain",
                    "Expected: " + expectedMessage + "\nActual: " + actualMessage);

            assertEquals(expectedMessage, actualMessage,
                    "Toast message verification failed.\nExpected: " + expectedMessage +
                            "\nActual: " + actualMessage);

        } catch (Exception e) {

                    takeScreenshotAsBytes();

            throw new AssertionError("Toast message verification failed: " + e.getMessage());
        }
    }

    @When("the user create new task from newly created task group")
    @Severity(SeverityLevel.NORMAL)
    @Step("User creates a new task from newly created task group")
    @Description("Create a new task from newly created task group from the task page")
    public void the_user_create_new_task_from_newly_created_task_group() throws IOException
    {
       pp.createnewtask1();
    }
    @When("the user edit the task")
    @Severity(SeverityLevel.NORMAL)
    @Step("User edits the task")
    @Description("Edit the task from the task page")
    public void the_user_edit_the_task()
    {
       pp.editTask();
    }
    @When("the user create check list")
    @Severity(SeverityLevel.NORMAL)
    @Step("User creates a new check list")
    @Description("Create a new check list from the task page")
    public void the_user_create_check_list() throws IOException
    {
        pp.addChecklistItems();
    }
    @Then("validate check list has created")
    @Step("Validate checklist creation with toast message")
    @Severity(SeverityLevel.CRITICAL)
    public void validate_check_list_has_created()
    {
        try {
            String actualMessage = pp.getToastMessage();

            if (actualMessage == null || actualMessage.isEmpty()) {
                Allure.addAttachment("Validation Failed", "text/plain",
                        "Toast message was empty or null");
                throw new AssertionError("Toast message is missing or empty!");
            }

            assertEquals("Checklist created", actualMessage.trim(),
                    "Checklist creation validation failed - unexpected toast message");

            Allure.addAttachment("Checklist Creation", "text/plain",
                    "Checklist created successfully with message: " + actualMessage);

        } catch (Exception e) {
                    takeScreenshotAsBytes(); throw e;
        }
    }

    @When("the user add items to the task")
    @Severity(SeverityLevel.NORMAL)
    @Step("User adds items to the task")
    @Description("Add items to the task from the task page")
    public void the_user_add_items_to_the_task()
    {
        pp.addItemsToTask();
    }
    @Then("validate items are added to task")
    @Step("Validate items added to task")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate items added to task")
    public void validate_items_are_added_to_task()
    {
        try {
            String actualMessage = pp.getToastMessage();

            if (actualMessage == null || actualMessage.isEmpty()) {
                Allure.addAttachment("Validation Failed", "text/plain",
                        "Toast message was empty or null");
                throw new AssertionError("Toast message is missing or empty!");
            }

            assertEquals("Items added", actualMessage.trim(),
                    "Items Added validation failed - unexpected toast message");

            Allure.addAttachment("Items added", "text/plain",
                    "Items added successfully with message: " + actualMessage);

        } catch (Exception e) {

            takeScreenshotAsBytes(); throw e;
        }

    }
    @When("the user close the task")
    @Severity(SeverityLevel.NORMAL)
    @Step("User closes the task")
    @Description("Close the task from the task page")
    public void the_user_close_the_task()
    {
        pp.closeTask();
    }
    @When("the user click schedule button from created task")
    @Severity(SeverityLevel.NORMAL)
    @Step("User clicks schedule button from created task")
    @Description("Click schedule button from the created task")
    public void the_user_click_schedule_button_from_created_task()
    {
        pp.createschedule();
    }
    @Then("validate schedule has been created")
    @Step("Validate schedule creation with toast message")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate schedule has been created")
    public void validate_schedule_has_been_created()
    {
        try {
            String actualMessage = pp.getToastMessage();

            if (actualMessage == null || actualMessage.isEmpty()) {
                Allure.addAttachment("Validation Failed", "text/plain",
                        "Toast message was empty or null");
                throw new AssertionError("Toast message is missing or empty!");
            }

            assertEquals(" Event created", actualMessage.trim(),
                    " Event created validation failed - unexpected toast message");

            Allure.addAttachment(" Event created", "text/plain",
                    " Event created successfully with message: " + actualMessage);

        } catch (Exception e) {

            takeScreenshotAsBytes(); throw e;
        }

    }
    @When("the user go to time tracking section")
    @Severity(SeverityLevel.NORMAL)
    @Step("User navigates to time tracking section")
    @Description("Navigate to time tracking section from the main application menu")
    public void the_user_go_to_time_tracking_section()
    {
        pp.navigateToTimeTracking();
    }
    @When("the user add new time entry")
    @Severity(SeverityLevel.NORMAL)
    @Step("User adds new time entry")
    @Description("Add new time entry from the time tracking section")
    public void the_user_add_new_time_entry()
    {
        pp.createTimeEntry();
    }
    @Then("validate time entry added or not")
    @Step("Validate time entry added or not")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate time entry added or not")
    public void validate_time_entry_added_or_not()
    {
        pp.validateTimeEntry();
    }
    @When("the user go to project overview page")
    @Severity(SeverityLevel.NORMAL)
    @Step("User navigates to project overview page")
    @Description("Navigate to project overview page from the main application menu")
    public void the_user_go_to_project_overview_page()
    {
        pp.navigateToProjectOverview();
    }
    @When("the user go to payment page")
    @Severity(SeverityLevel.NORMAL)
    @Step("User navigates to payment page")
    @Description("Navigate to payment page from the main application menu")
    public void the_user_go_to_payment_page()
    {
        pp.navigateToPayments();
    }
    @When("the user crete new payment request")
    @Severity(SeverityLevel.NORMAL)
    @Step("User creates new payment request")
    @Description("Create new payment request from the payment page")
    public void the_user_crete_new_payment_request()
    {
        pp.createNewPaymentRequest();
    }
    @Then("validate payment request created as per given data")
    @Step("Validate payment request created as per given data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate payment request created as per given data")
    public void validate_payment_request_created_as_per_given_data()
    {
        try {
            boolean isPaymentRequestVisible = pp.validatePaymentRequest();

            Allure.addAttachment("Payment Request Validation", "text/plain",
                    "Payment request element visibility: " + isPaymentRequestVisible);

            assertTrue(isPaymentRequestVisible,
                    "Payment request text was not displayed when it should be");

            if (isPaymentRequestVisible) {
                byte[] screenshot = ((TakesScreenshot) Base.getdriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Payment Request Screenshot", "image/png", new ByteArrayInputStream(screenshot).toString());
            }

        } catch (NoSuchElementException e) {
            Allure.addAttachment("Element Not Found", "text/plain",
                    "Payment request element could not be located: " + e.getMessage());
            throw new AssertionError("Payment request element not found in DOM", e);
        } catch (Exception e) {
            Allure.addAttachment("Validation Error", "text/plain",
                    "Unexpected error during payment request validation: " + e.getMessage());
            throw new AssertionError("Payment request validation failed", e);
        }
    }
    @When("the user share payment request via email")
    @Severity(SeverityLevel.NORMAL)
    @Step("User shares payment request via email")
    @Description("Share payment request via email from the payment page")
    public void the_user_share_payment_request_via_email() throws IOException
    {
        pp.sharePaymentViaEmail();
    }
    @Then("validate payemnt shared or not")
    @Step("Validate payment shared or not")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate payment shared or not")
    public void validate_payemnt_shared_or_not()
    {
        try {
            String actualMessage = pp.getToastMessage();

            if (actualMessage == null || actualMessage.isEmpty()) {
                Allure.addAttachment("Validation Failed", "text/plain",
                        "Toast message was empty or null");
                throw new AssertionError("Toast message is missing or empty!");
            }

            assertEquals("Invoice shared", actualMessage.trim(),
                    "Invoice shared validation failed - unexpected toast message");

            Allure.addAttachment("Invoice shared", "text/plain",
                    "Invoice shared successfully with message: " + actualMessage);

        } catch (Exception e) {

            takeScreenshotAsBytes(); throw e;
        }

    }
    @When("the user mark payment stats as paid")
    @Severity(SeverityLevel.NORMAL)
    @Step("User marks payment stats as paid")
    @Description("Mark payment stats as paid from the payment page")
    public void the_user_mark_payment_stats_as_paid()
    {
        pp.updatePaymentStatus();
    }
    @Then("validate payment summary section")
    @Step("Validate payment summary section")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate payment summary section")
    public void validate_payment_summary_section()
    {
        boolean isValid = pp.validatePaymentSummary();

        if (!isValid) {
            Allure.addAttachment("Payment Summary Validation", "text/plain",
                    "Mismatch found between paid status and section");
            throw new AssertionError("Payment summary validation failed.");
        }

        Allure.addAttachment("Payment Summary Validation", "text/plain",
                "Payment summary validation passed.");
    }
    }

