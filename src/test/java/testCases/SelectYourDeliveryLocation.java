package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Hooks;

public class SelectYourDeliveryLocation extends Hooks {
    HomePage homePage = new HomePage();

    @Test
    public void setDeliveryLocation() throws InterruptedException {
        homePage.navigateURL(homePage.baseURL);
        Assert.assertEquals(homePage.getCurrentURL(), "https://www.shwapno.com/");
        Assert.assertEquals(homePage.getTitle(), "Shwapno Online Grocery Shopping in Dhaka, Chattogram, Cumilla & Sylhet");

        //Select Your City
        homePage.selectByVisibleText(homePage.selectYourCity, "Dhaka");

        //Select Your Area
        homePage.selectByValueWithScroll(homePage.selectYourArea, homePage.scrollYourArea,"26346");

        //Click on Submit button
        homePage.click(homePage.submitBtn);

        //Click On Cancel
        //homePage.click(homePage.cancelIcon);


    }

}
