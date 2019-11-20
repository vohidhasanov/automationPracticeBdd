package com.automationpractice.runner;

import com.automationpractice.utilities.CommonStep;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"html:target/cucumber_report"
                  ,"json:target/cucumber_report/cucumber.json"
                  ,"rerun:target/failed_scenarios/rerun.txt"
                },
        features = {"src\\test\\resources\\features"},

        glue = {    "com.automationpractice.steps", "com.mockaroo.excel_generator" },
        tags={  "@excel1"
             //   "@login", "@wip"
              //  "@login"
        }  //~@contactUs // tilda is used to skip scenarios/features

      //  ,dryRun=true
)
public class Runner extends CommonStep {

    @AfterClass
    public static void after () {
        closeDriver();
    }
}
