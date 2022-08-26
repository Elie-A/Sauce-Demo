package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.applicationUtilities.MiscellaneousApplicationUtilities;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoSocialPage extends PageObjectManager {

    String socialLinkXpath = "//li[contains(@class,%s)]";
    public SauceDemoSocialPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getSocialLink(String text){
        return driver.findElement(By.xpath(String.format(socialLinkXpath, text)));
    }

    public void clickSocial(String text){
        clickElement(getSocialLink(text));
    }

    public boolean isOnSocialPage(String text){
        boolean bool = false;
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl().toLowerCase().contains(text.toLowerCase()));
        bool = driver.getCurrentUrl().toLowerCase().contains(text.toLowerCase());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return bool;
    }
}
