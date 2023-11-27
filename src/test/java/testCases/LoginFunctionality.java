package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Hooks;

public class LoginFunctionality extends Hooks {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test()
    public void loginWithMobileNumber(){
        SoftAssert softAssert = new SoftAssert();

        homePage.navigateURL(homePage.baseURL);
        Assert.assertEquals(homePage.getCurrentURL(), "https://www.shwapno.com/");
        Assert.assertEquals(homePage.getTitle(), "Shwapno Online Grocery Shopping in Dhaka, Chattogram, Cumilla & Sylhet");

        if(homePage.isDisplayed(homePage.cancelIcon)){
            homePage.click(homePage.cancelIcon);
        }

        //Hover on Profile Logo
        homePage.mouseHover(homePage.profileIcon);
        //Clik on My Profile
        homePage.click(homePage.myProfile);
        Assert.assertEquals(loginPage.getCurrentURL(), loginPage.loginPageURL);
        Assert.assertEquals(loginPage.getTitle(), "Login");
        Assert.assertTrue(loginPage.isDisplayed(loginPage.loginWithMobileNumber));

        //Enter Mobile Number
        loginPage.clear(loginPage.mobileNumber);
        loginPage.sendKeys(loginPage.mobileNumber, "01521503629");
        //Click on Submit
        loginPage.click(loginPage.submitBtn);
        softAssert.assertTrue(loginPage.isDisplayed(loginPage.otpSent));


    }
}
