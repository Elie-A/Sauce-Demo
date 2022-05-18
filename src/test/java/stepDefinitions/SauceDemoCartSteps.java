package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.SauceDemoProductsPage;

public class SauceDemoCartSteps extends TestBase{

    @When("user clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        sauceDemoCartPage.clickCheckOut();
    }

    @Then("user validates items in shopping cart")
    public void user_validates_items_in_shopping_cart() {
        Assert.assertTrue(sauceDemoCartPage.validateItemsInCart(SauceDemoProductsPage.listOfProductInCart));
    }
}
