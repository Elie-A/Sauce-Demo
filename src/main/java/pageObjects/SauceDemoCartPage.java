package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SauceDemoCartPage extends PageObjectManager {

    @FindBy(className = "title")
    List<WebElement> title;

    @FindBy(id = "checkout")
    WebElement checkout;

    public SauceDemoCartPage(WebDriver driver){ super(driver); }

    public boolean isOnCartPage(String page){
        return isElementDisplayed(title);
    }

    public void clickCheckOut(){
        clickElement(checkout);
    }

    public boolean validateItemsInCart(List<String> expectedItems){
        List<WebElement> listOnItemsInCart = driver.findElements(By.className("inventory_item_name"));
        for(WebElement element : listOnItemsInCart){
            if(!expectedItems.contains(element.getText().trim())) return false;
        }
        return true;
    }
}
