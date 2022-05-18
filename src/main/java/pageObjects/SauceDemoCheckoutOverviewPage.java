package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SauceDemoCheckoutOverviewPage extends PageObjectManager {


    @FindBy(className = "title")
    List<WebElement> title;

    @FindBy(className = "summary_total_label")
    WebElement totalPriceLabel;

    @FindBy(id="finish")
    WebElement finishButton;

    public SauceDemoCheckoutOverviewPage(WebDriver driver){ super(driver); }

    public boolean isOnCheckoutOverviewPage(String page){
        return isElementDisplayed(title);
    }

    public float returnTotalPrice(){
        String text = totalPriceLabel.getText().trim();
        return Float.parseFloat(text.substring(text.lastIndexOf("$") + 1, text.length()));
    }

    public boolean validateTotalPrice(float price, float expectedPrice){
        return price == expectedPrice;
    }

    public void clickFinishButton(){
        clickElement(finishButton);
    }
}
