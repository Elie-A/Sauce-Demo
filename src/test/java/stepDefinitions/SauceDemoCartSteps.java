package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.SauceDemoProductsPage;

public class SauceDemoCartSteps extends TestBase{

    @Then("user validates items in shopping cart")
    public void user_validates_items_in_shopping_cart() {
        Assert.assertTrue(sauceDemoCartPage.validateItemsInCart(SauceDemoProductsPage.listOfProductInCart));
    }
}
