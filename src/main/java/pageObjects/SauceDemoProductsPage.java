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

public class SauceDemoProductsPage extends PageObjectManager {

    @FindBy(className = "product_sort_container")
    WebElement dropdown;

    @FindBy(className = "shopping_cart_badge")
    WebElement totalInCart;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;

    public static List<String> listOfProductInCart = new ArrayList<>();
    public static List<Float> listOfPricesInCart = new ArrayList<>();

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

    public void clickOnAddRemoveProductToFromCart(String text, String total){
        int totalProducts = Integer.parseInt(total);
        List<WebElement> list = driver.findElements(By.xpath("//button[text()='"+text+"']"));
        List<WebElement> listNames = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        for(int i = 0; i < totalProducts; i++){
            if(text.toLowerCase().trim().contains("add")){
                clickElement(list.get(i));
                listOfProductInCart.add(listNames.get(i).getText().trim());
                listOfPricesInCart.add(Float.valueOf(prices.get(i).getText().trim().replace("$", "")));
            }else{
                clickElement(list.get(i));
                listOfProductInCart.remove(listNames.get(i).getText().trim());
                listOfPricesInCart.remove(Float.valueOf(prices.get(i).getText().trim().replace("$", "")));
            }
        }
    }

    public boolean validateTotalInCart(int requiredTotal){
        return Integer.parseInt(totalInCart.getText()) == requiredTotal;
    }

    public void clickShoppingCart(){
        clickElement(shoppingCart);
    }
}
