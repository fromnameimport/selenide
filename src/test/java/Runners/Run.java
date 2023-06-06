package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "C:\\Users\\user\\IdeaProjects\\SelenideCucumber\\src\\test\\resources\\test.feature",
        glue = {"StepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true
)
public class Run extends AbstractTestNGCucumberTests {
}
