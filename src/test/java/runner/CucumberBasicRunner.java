package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features/CucumberBasic.feature",
		glue={"stepDefenition"},
		plugin = {"pretty", "json:target/cucumber.json","html:target/result.html"}
		)

public class CucumberBasicRunner extends AbstractTestNGCucumberTests{

}
