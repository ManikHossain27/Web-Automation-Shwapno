package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utilities.Hooks.getDriver;

public class Base {
    public WebDriverWait wait;
    public Alert alert;
    public Actions actions;
    public Select select;

    //Navigate to site url
    public void navigateURL(String url){
        getDriver().get(url);
    }

    //Find an element
    public WebElement getElement(By locator){
        return waitForElementPresence(locator);
    }

    //Click on element
    public void click(By locator){
        waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    //Submit
    public void submit(By locator) {
        getElement(locator).submit();
    }

    //Get an element's text
    public String getText(By locator){
        return getElement(locator).getText();
    }

    //Get attribute Value
    public String getAttributeValue(By locator, String key) {
        return getElement(locator).getAttribute(key);
    }

    //Write on element
    public void sendKeys(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    //clear element field
    public void clear(By locator) {
        getElement(locator).clear();
    }

    //Check an element is visible or not
    public boolean isDisplayed(By locator){
        try {
            return getDriver().findElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }//isDisplayed

    public boolean isEnabled(By locator){
        try {
            return getDriver().findElement(locator).isEnabled();
        }catch (Exception e){
            return false;
        }
    }//isEnabled

    public boolean isSelected(By locator){
        try {
            return getDriver().findElement(locator).isSelected();
        }catch (Exception e){
            return false;
        }
    }//isDisplayed

    //Wait for an element to be present
    public WebElement waitForElementPresence(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Wait for an element to be clickable
    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        //wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Select an element by visible text
    public void selectByVisibleText(By locator, String text){
        click(locator);
        select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    //Select an element by value
    public void selectByValue(By locator, String value){
        click(locator);
        select = new Select(getElement(locator));
        select.selectByValue(value);
    }
    public void selectByValueWithScroll(By locator, By scrollLocator, String value){
        click(locator);
        //scrollToElement(scrollLocator);

//        actions = new Actions(getDriver());
//        actions.scrollToElement(getDriver().findElement(scrollLocator)).build().perform();

        select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    //Deselect an element by visible text
    public void deselectByVisibleText(By locator, String text){
        click(locator);
        select = new Select(getElement(locator));
        select.deselectByVisibleText(text);
    }

    //Deselect an element by value
    public void deselectByValue(By locator, String value){
        click(locator);
        select = new Select(getElement(locator));
        select.deselectByValue(value);
    }
    //Get first selected options text
    public String getFirstSelectedOption(By locator, String value){
        select = new Select(getElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    //multiple select
//    public static void multipleSelect(By locator, String value){
//        select = new Select(getElement(locator));
//        select.deselectByValue(value);
//    }


    public void mouseHover(By locator) {
        actions = new Actions(getDriver());
        //WebElement element2 = getDriver().findElement(locator);
        actions.moveToElement(getElement(locator)).build().perform();
    }
    public String getTitle(){
        return getDriver().getTitle();
    }
    public String getCurrentURL(){
        return getDriver().getCurrentUrl();
    }
    public void navigateBack(){
        getDriver().navigate().back();
    }
    public void navigateForward(){
        getDriver().navigate().forward();
    }
    public void refresh(){
        getDriver().navigate().refresh();
    }
    public void openNewTab(String locator){
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get(locator);//new tab page url
    }
    public void openNewWindow(String locator){
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        getDriver().get(locator);//new tab page url
    }

    //When a new tab is open by click a link/button then we use it
    public void windowHandles(int value){
        List<String> windowHandles = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(value));
    }

    public void alertAccept(){
        alert = getDriver().switchTo().alert();
        alert.accept();
    }
    public void alertDismiss(){
        alert = getDriver().switchTo().alert();
        alert.dismiss();
    }
    public String alertGetText(){
        alert = getDriver().switchTo().alert();
        return alert.getText();
    }
    public void alertSendKeys(String keys){
        alert = getDriver().switchTo().alert();
        alert.sendKeys(keys);
    }
    public void scrollToElement(By locator){
        actions = new Actions(getDriver());
        actions.scrollToElement(getElement(locator)).build().perform();
    }
    public void iframeIN(String attributeValue){
        getDriver().switchTo().frame(attributeValue);
    }
    public void iframeOUT(String attributeValue){
        getDriver().switchTo().defaultContent();
    }



}//Base
