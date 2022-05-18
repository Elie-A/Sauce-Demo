package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCheckoutPage extends PageObjectManager {

    @FindBy(className = "title")
    List<WebElement> title;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id="continue")
    WebElement continueButton;


    public SauceDemoCheckoutPage(WebDriver driver) { super(driver); }

    private void enterFirstName(String text){
        enterText(firstNameField, text);
    }

    private void enterLastName(String text){
        enterText(lastNameField, text);
    }

    private void enterPostalCode(String text){
        enterText(postalCodeField, text);
    }

    private void clickContinue(int msec){
        clickElementWithWait(continueButton, msec);
    }

    public boolean isOnCheckoutPage(String page){
        return isElementDisplayed(title);
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode, int msec){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue(msec);
    }

    public List<Float> returnPriceList(){
        List<Float> priceList = new ArrayList<>();
        List<WebElement> priceListWeb = driver.findElements(By.className("inventory_item_price"));
        for(WebElement element: priceListWeb){
            priceList.add(Float.parseFloat(element.getText().trim().replace("$", "")));
        }
        return priceList;
    }

    public boolean validatePriceList(List<Float> prices, List<Float> expectedPrices){
        return prices.equals(expectedPrices);
    }
}
