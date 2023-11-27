package pages;

import base.Base;
import org.openqa.selenium.By;

public class LoginPage extends Base {
    public String loginPageURL = "https://www.shwapno.com/Registration/Login.aspx?ReturnUrl=https://www.shwapno.com/Registration/MyAccount.aspx?tabkey=Profile";
    public By loginWithMobileNumber = By.xpath("//a[@id='tab1']");
    public By mobileNumber = By.xpath("//input[@id='txtCRMMobileNOLogin']");
    public By submitBtn = By.xpath("//a[@id='btnValidateMob']");
    public By otpSent = By.xpath("//a[@id='btnValidateOTP']");
}
