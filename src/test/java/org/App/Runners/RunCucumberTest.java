package org.App.Runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.App.StepDefinition")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty," +
        "html:target/cucumber.html," +
        "json:target/cucumber.json," +
        "junit:target/cucumber.xml")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Sanity-positive")
public class RunCucumberTest {
}