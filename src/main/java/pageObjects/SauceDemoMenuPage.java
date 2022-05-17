package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoMenuPage extends PageObjectManager {

    @FindBy(id="react-burger-menu-btn")
    WebElement menuIcon;

    String menuItem = "//a[text()='%s']";
    WebElement menuElement;

    public SauceDemoMenuPage(WebDriver driver) { super(driver); }

    private WebElement returnMenuElement(String menuItemText){
        WebElement element = driver.findElement(By.xpath(String.format(menuItem, menuItemText)));
        return element;
    }

    public void clickHamburgerIcon(){
        clickElement(menuIcon);
    }

    public void navigateToMenuItem(String menuItemText, int msec){
        menuElement = returnMenuElement(menuItemText);
        clickElementWithWait(menuElement, msec);
    }
}
