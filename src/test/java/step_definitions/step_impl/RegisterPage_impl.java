package step_definitions.step_impl;

import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import testData.NewUserInfo;
import util.Driver;
import util.SeleniumUtils;

public class RegisterPage_impl {
    private static WebDriver driver = Driver.getDriver();
    SignInPage signInPage = new SignInPage();
    VerifyHomePageTitle_impl homePage = new VerifyHomePageTitle_impl();


    public void navigateToRegisterPage(){
        homePage.clickSignUp();
    }

    public void registerNewUser(){
        NewUserInfo user = new NewUserInfo();
        homePage.clickSignUp();
        SeleniumUtils.sendKeys(signInPage.firstName, user.getFirstName());
        SeleniumUtils.sendKeys(signInPage.lastName, user.getLastName());
        SeleniumUtils.sendKeys(signInPage.phone, user.getCellPhoneNum());
        SeleniumUtils.sendKeys(signInPage.email, user.getEmail());
        SeleniumUtils.sendKeys(signInPage.password, user.getPassword());
        SeleniumUtils.sendKeys(signInPage.confirmPassword, user.getPassword());

        clickSignUp();
    }

    public void clickSignUp(){
        SeleniumUtils.click(signInPage.signUp_Btn);
    }

    public String getTilte(){
        return driver.getTitle();
    }

}
