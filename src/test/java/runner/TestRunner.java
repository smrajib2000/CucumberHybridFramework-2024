
package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
					glue= {"stepdefinitions","hooks"},
					plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"}
					)
public class TestRunner {

}
