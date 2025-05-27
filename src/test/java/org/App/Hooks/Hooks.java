package org.App.Hooks;

import io.cucumber.java.*;
import org.App.Factory.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class Hooks {
    private WebDriver driver;
    private Properties properties;

    public Hooks() {
        try {
            Base base = new Base(); // manually create instance
            this.driver = base.getdriver();
            this.properties = base.getProperties();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize Base in Hooks", e);
        }
    }

    @Before
    public void setupBrowser() {
        System.out.println("Launching browser");
        System.out.println("Loading config for: " + properties.getProperty("env"));
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure_screenshot");
            driver.quit();
        }
    }

    @After(order = 1)
    public void afterScenario() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    @AfterAll
    public static void afterAll() {
        Base.getLogger().info("Closing browser");
        Base.getdriver().quit();
        System.out.println("Test execution completed");
    }
}
