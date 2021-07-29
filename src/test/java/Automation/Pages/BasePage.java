package Automation.Pages;

import Automation.Utilities.Driver;
import Automation.Utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @AndroidFindBy(id = "......")
    private MobileElement getStarted;

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.get()), this);
    }


    public void clickOnGetStarted() {
        MobileUtilities.waitForPresence(By.id("...."));
        getStarted.click();
    }
}
