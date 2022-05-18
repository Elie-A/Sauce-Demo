package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SauceDemoLoginPage extends PageObjectManager {

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "title")
    List<WebElement> title;

    public SauceDemoLoginPage(WebDriver driver){ super(driver); }

    public void enterUsername(String text){
        enterText(usernameField, text);
    }

    public void enterPassword(String text){
        enterText(passwordField, text);
    }

    public void clickLogin(int msec){
        clickElementWithWait(loginButton, msec);
    }

    public boolean isOnProductsPage(String page){
        return isElementDisplayed(title);
    }

    public boolean isDriverRunning(){
        return driver != null;
    }

    public void killDriver(boolean isRunning){
        if(isRunning) killDriverInstance();
    }
}
