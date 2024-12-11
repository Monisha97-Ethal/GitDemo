package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features/LoginwithDataTableStep.feature",
		glue={"stepDefenition"},
		plugin = {"pretty", "json:target/cucumber.json","html:target/result.html"}
		)
public class DatatableRunner  extends AbstractTestNGCucumberTests{

}
