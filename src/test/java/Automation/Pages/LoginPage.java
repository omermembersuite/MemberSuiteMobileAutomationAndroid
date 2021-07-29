package Automation.Pages;


import Automation.Utilities.ConfigurationReader;
import Automation.Utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "edit_username")
    private MobileElement emailOrUsernameElement;

    @AndroidFindBy(id = "edit_password")
    private MobileElement passwordElement;

    @AndroidFindBy(id = "button_signin")
    private MobileElement signInBtnElement;


    public void login() {
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");

        MobileUtilities.waitForPresence(By.id("id/edit_username"));

        emailOrUsernameElement.sendKeys(email);
        passwordElement.sendKeys(password);

        signInBtnElement.click();
    }
}
