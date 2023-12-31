package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class Hooks {
    private static String browserName = System.getProperty("browser", "chrome");

    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        Hooks.LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    public static WebDriver createBrowser(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser not found! using the given name: " + browserName);
        }
    }

    @BeforeSuite
    public static synchronized void setup(){
        WebDriver driver = createBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        setDriver(driver);
    }

    @AfterSuite
    public static synchronized void tearDown(){
        getDriver().quit();
    }

}
