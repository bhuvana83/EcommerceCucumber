package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//src/test/java/features/Login.feature",
		glue = "stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"},
		tags={"@sanity"}
		)
public class TestRunner {

}
