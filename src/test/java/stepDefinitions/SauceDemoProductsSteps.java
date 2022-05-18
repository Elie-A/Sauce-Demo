package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.SauceDemoProductsPage;

public class SauceDemoProductsSteps extends TestBase{


    int total = 0;
    int totalRemove = 0;

    @When("user selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String sortBy) {
        sauceDemoProductsPage.selectSortBy(sortBy);
    }

    @Then("items are sorted by {string} in {string} order")
    public void items_are_sorted_by_in_order(String sortBy, String order) {
        Assert.assertTrue(sauceDemoProductsPage.validateSortBy(sortBy, order), "Invalid sort by " + sortBy + " in " + order + " order");
    }

    @When("user clicks on {string} button of {string} products")
    public void user_clicks_on_button_of_products(String buttonText, String totalProducts) {
        total = Integer.parseInt(totalProducts);
        totalRemove = Integer.parseInt(totalProducts);
        sauceDemoProductsPage.clickOnAddRemoveProductToFromCart(buttonText, totalProducts);
    }

    @Then("products are added to the cart")
    public void products_are_added_to_the_cart() {
        Assert.assertTrue(sauceDemoProductsPage.validateTotalInCart(total));
    }

    @Then("products are removed from the cart")
    public void products_are_removed_from_the_cart() {
        Assert.assertTrue(sauceDemoProductsPage.validateTotalInCart(SauceDemoProductsPage.listOfProductInCart.size()));
    }

    @Given("user clicks on the shopping cart")
    public void user_clicks_on_the_shopping_cart() {
        sauceDemoProductsPage.clickShoppingCart();
    }
}
