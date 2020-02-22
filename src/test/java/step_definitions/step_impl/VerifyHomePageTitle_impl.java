package step_definitions.step_impl;

import org.openqa.selenium.WebDriver;
import pages.VerifyHomePageTitle;
import util.Driver;
import util.SeleniumUtils;

public class VerifyHomePageTitle_impl {

    private static WebDriver driver = Driver.getDriver();
    VerifyHomePageTitle verifyHomePageTitle = new VerifyHomePageTitle();

    public String getTitle(){
        return driver.getTitle();
    }


}
