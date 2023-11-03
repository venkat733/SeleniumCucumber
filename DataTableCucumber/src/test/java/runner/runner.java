package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@InvalidCredentials or @ValidCredentials",features="src/test/resources/Features/DataTable.feature",glue="com.DataTableCucumber")

public class runner {

}
