package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PackagedDalAndSolaPage;
import pages.ShwapnoOwnProductPage;
import utilities.Hooks;

import static org.testng.Assert.assertTrue;

public class AddAnItemInCart extends Hooks {
    HomePage homePage = new HomePage();
    PackagedDalAndSolaPage packagedDalAndSolaPage = new PackagedDalAndSolaPage();
    ShwapnoOwnProductPage shwapnoOwnProductPage = new ShwapnoOwnProductPage();
    @Test
    public void AddMixedDalToCart(){
        homePage.navigateURL(homePage.baseURL);
        Assert.assertEquals(homePage.getCurrentURL(), "https://www.shwapno.com/");
        Assert.assertEquals(homePage.getTitle(), "Shwapno Online Grocery Shopping in Dhaka, Chattogram, Cumilla & Sylhet");

        if(homePage.isDisplayed(homePage.cancelIcon)){
            homePage.click(homePage.cancelIcon);
        }
        homePage.click(homePage.ourOwnProduct);
        Assert.assertEquals(shwapnoOwnProductPage.getText(shwapnoOwnProductPage.mixedDal1Kg), "Shwapno Mixed Dal 1Kg");

        shwapnoOwnProductPage.click(shwapnoOwnProductPage.mixedDalImg);
        Assert.assertEquals(packagedDalAndSolaPage.getText(packagedDalAndSolaPage.itemName), "Shwapno Mixed Dal 1Kg");
        Assert.assertEquals(packagedDalAndSolaPage.getText(packagedDalAndSolaPage.mixedDalOldPrice), "150");
        Assert.assertEquals(packagedDalAndSolaPage.getText(packagedDalAndSolaPage.mixedDalPrice), "140");

        if (packagedDalAndSolaPage.isDisplayed(packagedDalAndSolaPage.mixedDalAvailablity)){
            packagedDalAndSolaPage.click(packagedDalAndSolaPage.addToCartBtn);
            Assert.assertEquals(packagedDalAndSolaPage.getText(packagedDalAndSolaPage.cartItemNumber), "1");
        }



    }

}
