package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features=".//features/Customers.feature"	,
		//	features=".//features/Login.feature"	
	glue="stepDefinitions",
	//dryRun=true,
	plugin={"pretty","html:target/cucumber-html-report","json:target/cucumber-json-report.json","junit:target/cucumber-junit-report.xml"},
	monochrome=true
	//tags= "@Smoke"
		)


public class myTestRunner {

}
