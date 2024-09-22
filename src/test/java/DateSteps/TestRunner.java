package DateSteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/calculate_age.feature"},
        glue = {"DateSteps"},
        plugin ={"pretty" , "html:target/cucumber-report.html"},
        monochrome = true)

public class TestRunner {
}
