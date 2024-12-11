package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features/features",
		glue={"stepDefenition"},
		//tags="not @RegressionTest",
		plugin = {"pretty", "json:target/cucumber.json","html:target/result.html"})
public class SmokeRegressionRunner extends AbstractTestNGCucumberTests{
	

}
