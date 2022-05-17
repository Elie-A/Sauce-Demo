package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.applicationUtilities.MiscellaneousApplicationUtilities;

import java.util.List;

public class SauceDemoProductsPage extends PageObjectManager {

    @FindBy(className = "product_sort_container")
    WebElement dropdown;

    public SauceDemoProductsPage(WebDriver driver){ super(driver); }

    public void selectSortBy(String sortBy){
        Select select = new Select(dropdown);
        select.selectByVisibleText(sortBy);
    }

    public boolean validateSortBy(String sortBy, String order){
        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        switch (sortBy){
            case "Name (A to Z)":
            case "Name (Z to A)":
                return MiscellaneousApplicationUtilities.isListOfStringSorted(names, order);
            case "Price (low to high)":
            case "Price (high to low)":
                return MiscellaneousApplicationUtilities.isListOfNumbersSorted(prices, order);
            default:
                return true;
        }
    }
}
