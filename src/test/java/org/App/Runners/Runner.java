package org.App.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/SanityTest",
                //"src/test/resources/features/regression",
                //"classpath:features" // Alternative if using classpath
        },
        glue = {
                "org.App.StepDefinition",      // Updated package
                "org.App.Hooks",         // Include hooks
                "org.App.config"         // Include config classes
        },
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "rerun:target/rerun/failed_scenarios.txt", // Better rerun file location
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                //"tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/imeline" // For parallel execution
        },
        tags = "@Sanity", // More flexible tag expressions
        dryRun = false,
        monochrome = true,
        publish = true,
        stepNotifications = true // Show step-level notifications
)

public class Runner
{

}
