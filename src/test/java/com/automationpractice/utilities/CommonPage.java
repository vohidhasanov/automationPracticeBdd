package com.automationpractice.utilities;

import org.openqa.selenium.WebDriver;

public abstract class CommonPage extends DriverHelper{
  //  private DriverHelper  driverHelper;

    protected CommonPage (WebDriver driver) {
       super(driver);
        // if (driverHelper==null) driverHelper = new DriverHelper(driver);
    }

    protected abstract boolean isLoaded();

//    protected DriverHelper getDriverHelper () {
//        return driverHelper;
//    }
}
