package cucumberdemo.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features", 
		glue="cucumberdemo.stepdefinitions", 
		monochrome=true, 
		plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",
				 "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", 
				"junit:target/cucumber-results.xml"})
public class TestRunner {
	
}
