package test.progob;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "test.resources.progob",
        glue = "test.progob"
)
public class RunAccountsTest {
}
