package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/JiraAssignmentwee4day1.feature",glue="stepdefinition",monochrome=true,publish=true)
public class jiraweek4day1assignment extends AbstractTestNGCucumberTests{

}