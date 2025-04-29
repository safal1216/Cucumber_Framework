package org.epam.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/features",
        glue = {"org.epam.stepDefinition", "org.epam.hooks"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
