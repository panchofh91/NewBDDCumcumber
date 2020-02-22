package step_definitions;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.VerifyHomePageTitle;
import step_definitions.step_impl.VerifyHomePageTitle_impl;
import util.ConfigReader;
import util.Driver;


public class VerifyHomePageTitle_STEPS {
    private static WebDriver driver = Driver.getDriver();
    VerifyHomePageTitle verifyHomePageTitle = new VerifyHomePageTitle();
    VerifyHomePageTitle_impl verifyHomePage_Title_impl = new VerifyHomePageTitle_impl();

    @Given("User opens home page")
    public void user_opens_home_page() {
    }

    @Then("User Verifies title is My Store")
    public void verifiesTitleIsMyStore() {
        Assert.assertEquals("My Store", driver.getTitle());
    }

}
