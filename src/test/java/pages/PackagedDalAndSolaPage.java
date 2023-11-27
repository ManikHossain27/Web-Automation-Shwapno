package pages;

import base.Base;
import org.openqa.selenium.By;

public class PackagedDalAndSolaPage extends Base {
    public By itemName = By.xpath("//div[@class='productdetail_leftdiv']//h1[1]");
    public By mixedDalPrice = By.xpath("//span[@id='lblOfferPrice']/span[@class='sp_amt']");
    public By mixedDalOldPrice = By.xpath("//span[@id='lblMrp']/span[@class='sp_amt']");
    public By mixedDalAvailablity = By.xpath("//div[@class='instock']");
    public By addToCartBtn = By.xpath("//a[normalize-space()='Add to Cart']");
    public By cartItemNumber = By.xpath("//label[@class='cartitem_number hasitems show_quickview']");
}
