package pages;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ConfigReader;
import util.Driver;

public class VerifyHomePageTitle {
    private static WebDriver driver = Driver.getDriver();
    public VerifyHomePageTitle(){
        PageFactory.initElements(driver, this);
    }



    public void verifyTitleOfCurrentPage() {
        Driver.getDriver().get(ConfigReader.readProperty("url"));
    }

    public String getTitle(){
        return driver.getTitle();
    }

}
