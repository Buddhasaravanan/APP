package org.App.Runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Modern TestRunner class using JUnit 5 Platform Suite
 * Configured for Allure reporting integration
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "org.App.StepDefinition,org.App.Hooks")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Sanity-positive")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value =
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm," +
                "pretty," +
                //"html:target/cucumber-reports," +
                "json:target/cucumber-reports/Cucumber.json," +
                "junit:target/cucumber-reports/Cucumber.xml," )
                //"tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter"


@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
//@ConfigurationParameter(key = Constants.EXECUTION_STRICT_PROPERTY_NAME, value = "true")
public class TestRunner {
    // This class remains empty - configuration is handled by annotations
}