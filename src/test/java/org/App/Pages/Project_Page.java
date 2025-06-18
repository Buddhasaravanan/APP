package org.App.Pages;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Allure;
import org.App.Factory.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Project_Page extends Basepage
{
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(30);
    private final WebDriverWait wait;
    private final Actions actions;

        // Toast message
        @FindBy(xpath = "//div[@class='cdk-overlay-pane']")
        private WebElement toastMessage;

        // Navigation elements
        @FindBy(id = "app-nav-projects")
        private WebElement projectNav;
        @FindBy(id = "nav-plan")
        private WebElement planNav;
        @FindBy(id = "nav-project-overview")
        private WebElement overviewNav;
        @FindBy(id = "nav-project-detail")
        private WebElement detailsNav;
        @FindBy(id = "nav-attachments")
        private WebElement attachmentsNav;
        @FindBy(id = "nav-activity")
        private WebElement activityNav;
        @FindBy(id = "nav-review")
        private WebElement reviewNav;

        // Task elements
        @FindBy(xpath = "//span[contains(text(), 'Tasks')]")
        private WebElement tasksSection;
        @FindBy(xpath = "(//a[contains(text(), 'create a new task')])[1]")
        private WebElement createNewTaskBtn;
        @FindBy(xpath = "(//a[contains(text(), 'create a new task')])[3]")
        private WebElement createNewTaskBtnAlt;
        @FindBy(xpath = "//input[@placeholder='Task name']")
        private WebElement taskNameInput;
        @FindBy(xpath = "//mat-icon[@svgicon='calendarRange']")
        private WebElement taskCalendarBtn;
        @FindBy(xpath = "//mat-icon[@svgicon='person']")
        private WebElement resourceBtn;
        @FindBy(xpath = "//span[contains(text(),'Ajai DND')]")
        private WebElement ajaiResource;
        @FindBy(xpath = "(//div[contains(text(),'Ajai DND')])[1]")
        private WebElement ajaiResourceAlt;
        @FindBy(xpath = "//span[contains(text(),'Siva - DND')]")
        private WebElement sivaResource;
        @FindBy(id = "resourceAssign")
        private WebElement assignBtn;
        @FindBy(xpath = "(//span[contains(text(),'Create')])[1]")
        private WebElement createBtn;
        @FindBy(xpath = "//a[contains(text(),'Add task')]")
        private WebElement addTaskBtn;
        @FindBy(xpath = "//mat-icon[@svgicon='closeIcon']")
        private WebElement cancelTaskBtn;
        @FindBy(xpath = "//span[contains(text(),'Schedule')]")
        private WebElement scheduleBtn;
        @FindBy(xpath = "//span[contains(text(),'New task group')]")
        private WebElement newTaskGroupBtn;
        @FindBy(xpath = "//input[@placeholder='Task group name']")
        private WebElement taskGroupNameInput;
        @FindBy(xpath = "(//span[@class='elipseName'])[1]")
        private WebElement firstTaskName;
        @FindBy(xpath = "(//mat-icon[@svgicon='moreHorzIcon'])[3]")
        private WebElement taskMoreOptionsBtn;
        @FindBy(xpath = "//span[contains(text(), 'Edit')]")
        private WebElement taskEditBtn;
        @FindBy(id = "checklistFocus")
        private WebElement checklistInput;
        @FindBy(xpath = "//a[contains(text(),'Add items')]")
        private WebElement addItemsBtn;
        @FindBy(id = "select-all-items-input")
        private WebElement selectAllItemsCheckbox;
        @FindBy(id = "btn-add-task-items")
        private WebElement addSelectedItemsBtn;
        @FindBy(xpath = "//span[contains(text(), 'Finished adding')]")
        private WebElement finishedAddingBtn;
        @FindBy(id = "btn-close-task")
        private WebElement closeTaskBtn;
        @FindBy(xpath = "(//div[@class='cursor-pointer'])[2]")
        private WebElement taskElement;

        // Scheduling elements
        @FindBy(xpath = "//span[contains(text(),' Scheduling')]")
        private WebElement schedulingSection;
        @FindBy(xpath = "(//mat-icon[@svgicon='addIcon'])[1]")
        private WebElement addScheduleBtn;
        @FindBy(xpath = "//a[contains(text(), 'Assign Task')]")
        private WebElement assignTaskBtn;
        @FindBy(xpath = "(//input[@type='checkbox'])[1]")
        private WebElement firstTaskCheckbox;
        @FindBy(xpath = "//span[contains(text(), 'Add selected tasks')]")
        private WebElement addSelectedTasksBtn;

        // Time tracking elements
        @FindBy(xpath = "//span[contains(text(), 'Time Tracking')]")
        private WebElement timeTrackingSection;
        @FindBy(id = "btnTimeEntry")
        private WebElement addTimeEntryBtn;
        @FindBy(id = "txt-app-search")
        private WebElement resourceSearchInput;
        @FindBy(xpath = "(//input[@aria-autocomplete='list'])[2]")
        private WebElement projectTaskSelect;
        @FindBy(xpath = "//div[@class='time-container']")
        private WebElement hoursWorkedContainer;
        @FindBy(id = "labor-thour-input")
        private WebElement laborHoursInput;
        @FindBy(id = "labor-tmin-input")
        private WebElement laborMinutesInput;
        @FindBy(xpath = "//input[@placeholder='Select Date(s)']")
        private WebElement timeEntryCalendar;
        @FindBy(xpath = "//span[contains(text(), '16')]")
        private WebElement day16;
        @FindBy(xpath = "//span[contains(text(),'Done')]")
        private WebElement calendarDoneBtn;
        @FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[3]")
        private WebElement laborTypeDropdown;
        @FindBy(xpath = "(//div[@role='option'])[2]")
        private WebElement taskOption;

        // Purchase order elements
        @FindBy(xpath = "//input[@type='checkbox']")
        private WebElement itemCheckbox;
        @FindBy(xpath = "//span[contains(text(), 'Create purchase order')]")
        private WebElement createPurchaseOrderBtn;
        @FindBy(id = "nav-product-status")
        private WebElement itemStatusNav;
        @FindBy(xpath = "//span[contains(text(), ' New for all ')]")
        private WebElement newForAllBtn;
        @FindBy(xpath = "//span[contains(text(), 'Continue')]")
        private WebElement continueBtn;
        @FindBy(xpath = "//span[contains(text(), 'Send PO')]")
        private WebElement sendPoBtn;
        @FindBy(xpath = "//mat-icon[@svgicon='closeIcon']")
        private WebElement closePoBtn;

        // Payment elements
        @FindBy(id = "nav-payments")
        private WebElement paymentsNav;
        @FindBy(xpath = "//a[contains(text(), 'New payment request')]")
        private WebElement newPaymentRequestBtn;
        @FindBy(id = "btn-done-automation-setup")
        private WebElement createPaymentsBtn;
        @FindBy(xpath = "//mat-icon[@svgicon='backIcon']")
        private WebElement paymentBackBtn;
        @FindBy(xpath = "//div[@aria-haspopup='menu']")
        private WebElement paymentStatusMenu;
        @FindBy(xpath = "(//span[contains(text(), ' Paid ')])[2]")
        private WebElement paidStatusOption;
        @FindBy(xpath = "//span[contains(text(), 'Save')]")
        private WebElement saveStatusBtn;
        @FindBy(xpath = "//span[contains(text(),' Invoice ')]")
        private WebElement paymentRequestText;
        @FindBy(xpath = "//mat-icon[@svgicon='proposalShare']")
        private WebElement sharePaymentBtn;
        @FindBy(xpath = "//span[contains(text(), 'Email')]")
        private WebElement emailShareOption;
        @FindBy(xpath = "//input[@placeholder='Type here to enter email or contact']")
        private WebElement emailToInput;
        @FindBy(xpath = "//span[contains(text(), 'Send')]")
        private WebElement sendEmailBtn;
        @FindBy(xpath = "(//span[contains(text(), '10')])[2]")
        private WebElement day10;
        @FindBy(xpath = "(//span[contains(text(), 'Add')])[2]")
        private WebElement timeEntryAddBtn;
        @FindBy(xpath = "(//input[@type='checkbox'])[2]")
        private WebElement secondCheckbox;
        @FindBy(xpath = "//div[contains(text(),'Dismiss')]")
        private WebElement dismissBtn;
        @FindBy(xpath = "//div[@class='banner orange']")
        private WebElement qbXeroBanner;
        @FindBy(xpath = "(//label[contains(text(),'Add Time Entry')])[1]")
        private WebElement timeEntryTitle;
        @FindBy(xpath = "(//textarea[@placeholder='Notes'])[1]")
        private WebElement notesInput;
        @FindBy(xpath = "(//input[@id='time-dropdown'])[1]")
        private WebElement startTimeInput;
        @FindBy(xpath = "(//input[@id='time-dropdown'])[2]")
        private WebElement endTimeInput;
        @FindBy(xpath = "//div[contains(text(), '07:00 AM')]")
        private WebElement sevenAmOption;
        @FindBy(xpath = "//div[contains(text(), '03:00 PM')]")
        private WebElement threePmOption;
        @FindBy(xpath = "//div[@class='time-dropdown-container ng-star-inserted']")
        private WebElement timeDropdown;
        @FindBy(xpath = "//tr[@class='ng-star-inserted green']//td[7]")
        private WebElement paidStatusIndicator;
        @FindBy(xpath = "//*[@id='container-PPE-scroll']/div/app-project-payments/div/div[1]/div[2]/span[2]")
        private WebElement paidSection;
        @FindBy(xpath="(//a[contains (text(), 'create a new task')])[3]")
        private WebElement newtask1;

        public Project_Page(WebDriver driver) {
            super(driver);
            this.wait = new WebDriverWait(driver, DEFAULT_WAIT);
            this.actions = new Actions(driver);
        }

        public void navigateToPlan() {
            try {
                if (isElementDisplayed(qbXeroBanner)) {
                    dismissBanner();
                }
                clickElement(planNav);
            } catch (Exception e) {
                handleException("Error navigating to plan section", e);
            }
        }

        private void dismissBanner() {
            try {
                clickElement(dismissBtn);
                wait.until(ExpectedConditions.invisibilityOf(dismissBtn));
            } catch (Exception e) {
                handleException("Error dismissing banner", e);
            }
        }

        public void navigateToTasks() {
            try {
                clickElement(tasksSection);
                waitForPageLoad();
            } catch (Exception e) {
                handleException("Error navigating to tasks section", e);
            }
        }

        public void createNewTask() throws IOException {
            try {
                clickElement(createNewTaskBtn);
                enterText(taskNameInput, Base.getProperties().getProperty("Taskname"));
                selectDate(day10);
                assignResources();
                clickElement(createBtn);
            } catch (Exception e) {
                handleException("Error creating new task", e);
            }
        }

        private void assignResources() {
            try {
                clickElement(resourceBtn);
                clickElement(ajaiResource);
                clickElement(sivaResource);
                clickElement(assignBtn);
            } catch (Exception e) {
                handleException("Error assigning resources", e);
            }
        }

        private void selectDate(WebElement dateElement) {
            try {
                clickElement(taskCalendarBtn);
                clickElement(dateElement);
            } catch (Exception e) {
                handleException("Error selecting date", e);
            }
        }

        public void createNewTaskGroup() throws IOException {
            try {
                clickElement(newTaskGroupBtn);
                enterText(taskGroupNameInput, Base.getProperties().getProperty("Taskgroupname"));
                clickElement(createBtn);
                waitForToastMessage();
            } catch (Exception e) {
                handleException("Error creating task group", e);
            }
        }

        public boolean validateTaskCreation() {
            return isElementDisplayed(scheduleBtn);
        }

        public String getToastMessage() {
            return toastMessage.getText();
        }

        public void editTask() {
            try {
                scrollToElement(timeTrackingSection);
                clickElement(firstTaskName);
                waitForPageLoad();
            } catch (Exception e) {
                handleException("Error editing task", e);
            }
        }

        public void createnewtask1() throws IOException
        {
            try
            {
                clickElement(newtask1);
                enterText(taskNameInput, Base.getProperties().getProperty("Taskname"));
                selectDate(day16);
                assignResources();
                clickElement(createBtn);
            } catch (Exception e) {
                handleException("Error editing task", e);
            }
        }

        public void addChecklistItems() throws IOException {
            try {
                enterText(checklistInput, Base.getProperties().getProperty("Taskchecklist") + Keys.ENTER);
                enterText(checklistInput, Base.getProperties().getProperty("Taskchecklist") + Keys.ENTER);
            } catch (Exception e) {
                handleException("Error adding checklist items", e);
            }
        }

    public void validateChecklistCreation() {
        String actualMessage = getToastMessage();

        if (actualMessage == null || actualMessage.isEmpty()) {
            throw new AssertionError("Toast message is missing or empty!");
        }

        assertEquals("Checklist created", actualMessage,
                "Checklist creation validation failed - unexpected toast message");
    }

        public void addItemsToTask() {
            try {
                clickElement(addItemsBtn);
                clickElement(selectAllItemsCheckbox);
                clickElement(addSelectedItemsBtn);
                clickElement(finishedAddingBtn);
            } catch (Exception e) {
                handleException("Error adding items to task", e);
            }
        }

        public void closeTask() {
            clickElement(closeTaskBtn);
        }

        public void createschedule()
        {
            try {
                clickElement(scheduleBtn);
                waitForPageLoad();
                scrollDown(0);
                clickElement(createBtn);
                waitForPageLoad();
            } catch (Exception e) {
                handleException("Error navigating to schedule section", e);
            }
        }

        public void navigateToTimeTracking() {
            try {
                scrollToTop();
                clickElement(timeTrackingSection);
                waitForPageLoad();
            } catch (Exception e) {
                handleException("Error navigating to time tracking", e);
            }
        }


        public void createTimeEntry() {
            try {
                clickElement(addTimeEntryBtn);
                selectResource();
                selectTask();
                setTimeRange();
                clickElement(timeEntryAddBtn);
            } catch (Exception e) {
                handleException("Error creating time entry", e);
            }
        }

        private void selectResource() {
            try {
                clickElement(resourceSearchInput);
                clickElement(ajaiResourceAlt);
            } catch (Exception e) {
                handleException("Error selecting resource", e);
            }
        }

        private void selectTask() {
            try {
                scrollDown(500);
                clickElement(projectTaskSelect);
                clickElement(taskOption);
                clickElement(laborTypeDropdown);
                clickElement(taskOption);
            } catch (Exception e) {
                handleException("Error selecting task", e);
            }
        }

        private void setTimeRange() {
            try {
                clickElement(startTimeInput);
                scrollDown(1000);
                clickElement(sevenAmOption);
                clickElement(endTimeInput);
                scrollDown(1000);
                clickElement(threePmOption);
            } catch (Exception e) {
                handleException("Error setting time range", e);
            }
        }

    public void validateTimeEntry() {
        String actualMessage = getToastMessage();

        if (actualMessage == null || actualMessage.isEmpty()) {
            Allure.addAttachment("Validation Failed", "text/plain",
                    "Toast message was empty or null");
            throw new AssertionError("Toast message is missing or empty!");
        }

        assertEquals("Time entry added", actualMessage,
                "Time entry validation failed - unexpected toast message");

        Allure.addAttachment("Time entry added", "text/plain",
                "Time entry validation successfully with message: " + actualMessage);
    }

        public void navigateToProjectOverview() {
            clickElement(overviewNav);
            waitForPageLoad();
        }

        public void navigateToPayments() {
            clickElement(detailsNav);
            clickElement(paymentsNav);
        }

        public void createNewPaymentRequest() {
            try {
                clickElement(newPaymentRequestBtn);
                waitForPageLoad();
                clickElement(createPaymentsBtn);
                waitForPageLoad();
            } catch (Exception e) {
                handleException("Error creating payment request", e);
            }
        }

        public boolean validatePaymentRequest() {
            return isElementDisplayed(paymentRequestText);
        }

        public void sharePaymentViaEmail() throws IOException {
            try {
                clickElement(sharePaymentBtn);
                clickElement(emailShareOption);
                enterText(emailToInput, Base.getProperties().getProperty("proposal_email") + Keys.ENTER);
                clickElement(sendEmailBtn);
            } catch (Exception e) {
                handleException("Error sharing payment via email", e);
            }
        }

        public boolean validateEmailShare() {
            return isElementDisplayed(toastMessage);
        }

        public void updatePaymentStatus() {
            try {
                clickElement(paymentBackBtn);
                waitForPageLoad();
                clickElement(paymentStatusMenu);
                clickElement(paidStatusOption);
                waitForPageLoad();
                clickElement(saveStatusBtn);
                waitForPageLoad();
            } catch (Exception e) {
                handleException("Error updating payment status", e);
            }
        }

        public boolean validatePaymentSummary() {
            String statusText = paidStatusIndicator.getText();
            String sectionText = paidSection.getText();
            return statusText.equals(sectionText);
        }

        // Helper methods
        private void clickElement(WebElement element) {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }

        private void enterText(WebElement element, String text) {
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        }

        private boolean isElementDisplayed(WebElement element) {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private void scrollToElement(WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }

        private void scrollToTop() {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
        }

        private void scrollDown(int pixels) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, " + pixels + ")");
        }

        private void waitForPageLoad() {
            try {
                Thread.sleep(3000); // Replace with proper page load wait if possible
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void waitForToastMessage() {
            wait.until(ExpectedConditions.visibilityOf(toastMessage));
        }

        private void handleException(String message, Exception e) {
            System.err.println(message + ": " + e.getMessage());
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new RuntimeException(message, e);
        }
    }

