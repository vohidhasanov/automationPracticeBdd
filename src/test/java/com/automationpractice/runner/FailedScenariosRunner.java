package com.automationpractice.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"html:target/cucumber_report"
                ,"json: target/cucumber_report/cucumber.json"
    //            ,"rerun: target/failed_scenarios/rerun.txt"
        },
        features = {"@target/failed_scenarios/rerun.txt"},
        glue = {    "com.automationpractice.steps" }

)
public class FailedScenariosRunner {



}
