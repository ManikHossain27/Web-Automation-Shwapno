package pages;

import base.Base;
import org.openqa.selenium.By;

public class HomePage extends Base {
    public  String baseURL = "https://www.shwapno.com/";
    public  By selectYourCity = By.xpath("//select[@id='state']");
    public By errorMsgForCity = By.xpath("//p[contains(text(),'Please select City.')]");
    public By selectYourArea = By.xpath("//select[@id='city']");
    public By errorMsgForArea = By.xpath("//p[@id='errorMsgEmpty']");
    public By scrollYourArea = By.xpath("//select/option[text()='Wari']");
    public By submitBtn = By.xpath("//input[@value='Submit']");
    public By selectedAreaName = By.xpath("//div[@class='postcodebutton']//div[@class='postcode_txt locareacode_txt']/span");
    public By setDeliveryLocation = By.xpath("//input[@id='btnChangeLocation']");
    public By cancelIcon = By.xpath("//div/span[@id='ui-id-1']/following-sibling::button");
    public By login = By.xpath("//a[contains(text(), ' login ')]");
    public By register = By.xpath("//div/a[contains(text(), ' register')]");

    //Sidebar loactors
    public By ourOwnProduct = By.xpath("//span[normalize-space()='Our Own Products']");
    public By cartValue = By.xpath("//label[normalize-space()='1']");;

    //Profile
    public By profileIcon = By.xpath("//div[@id='header']/div[@class='user-links']");
    public By myProfile = By.xpath("//a[text()='My Profile']");



}//Base
