package NKuhutan.TSB.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = {"NKuhutan.TSB.StepDefs"}, 
//		glue = {"src/test/java/NKuhutan/TSB/StepDefs/Steps.java"},
		plugin = {
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/json-cucumber-reports/default/cukejson.json",
				"testng:target/testng-cucumber-reports/cuketestng.xml" 
				}, 
		features = {"src/test/resources/features"}
		)
public class RunnerTest extends AbstractTestNGCucumberTests{

}
