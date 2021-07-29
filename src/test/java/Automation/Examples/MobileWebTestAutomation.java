package Automation.Examples;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MobileWebTestAutomation {
    //for mobile web automation, we don't use appium drivers
    //we just use WebDriver or RemoteWebDriver
    //RemoteWebDriver - it's a class, that implements WebDriver interface
    //RemoteWebDriver - is a super class for all web drivers, like: ChromeDriver, FirefoxDriver, IEDriver, etc..
    private RemoteWebDriver driver;

    /**
     */
    @Test
    public void test1() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID);
        desiredCapabilities.setCapability("platformVersion", "11.0");
        desiredCapabilities.setCapability("deviceName", "Pixel_2");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
      //  desiredCapabilities.setCapability("w3c", true);

        //change version based on the version of chrome browser
        WebDriverManager.chromedriver().version("2.23").setup();
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, WebDriverManager.chromedriver().getBinaryPath());
        //chrome options are used to parametrize chrome browser during test execution
        //you can use chrome option with desktop browser too
        //chrome options can be used to maximize browser,
        //disable popups
        //change save directory
        //set headless mode
        //enable proxy server
        //add extensions

        ChromeOptions chromeOptions = new ChromeOptions();
        //ignore SSL issues
        chromeOptions.setAcceptInsecureCerts(true);
        //to pass chrome options to the desired capabilities
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS, chromeOptions);

        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.get("http://membersuite.com/");
        Thread.sleep(5000);
//
//        driver.findElement(By.id("user_login")).sendKeys("username");
//        driver.findElement(By.id("user_password")).sendKeys("password", Keys.ENTER);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        //wait for board presence
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board")));

//        Assert.assertTrue(driver.findElement(By.className("brand")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("brand")).getText(),"....");

        //click on Online Statements
        driver.findElement(By.linkText("Online Statements")).click();

        Thread.sleep(5000);
        driver.quit();

//        Comeback in 1 hour
    }
}
