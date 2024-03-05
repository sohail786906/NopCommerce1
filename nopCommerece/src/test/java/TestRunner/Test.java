package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//Features/Customer.feature", ".//Features/Login.feature"},
		glue="StepDefinations", 
		dryRun=false,
		monochrome=true,
		//tags="@Sanity",
		plugin= {"pretty", "html:target/nopCommerece-reports/reports1.html"}
		)
public class Test {

}
 