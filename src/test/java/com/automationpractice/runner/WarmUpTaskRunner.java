package com.automationpractice.runner;

import com.automationpractice.utilities.CommonStep;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"html:target/cucumber_report"},
        glue = {"com.automationpractice.steps"},
        features = {"src\\test\\resources\\features\\warm_up\\warm_up.feature"}
       // ,features = {"src\\test\\resources\\features\\warm_up\\mackaroo.feature"}
        ,tags = {"@sampletable"}
      //  , dryRun = true
)

public class     WarmUpTaskRunner extends CommonStep {
//
    @AfterClass
    public static void after () {
    closeDriver();
    }
}