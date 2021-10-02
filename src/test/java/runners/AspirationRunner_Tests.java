package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/pretty.html",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        features = {
                "src/test/resources/features/"
        },
        glue = {"steps"},
        dryRun = false
)
public class AspirationRunner_Tests {
}
