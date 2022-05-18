package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.SauceDemoProductsPage;
import utilities.applicationUtilities.MiscellaneousApplicationUtilities;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCheckoutSteps extends TestBase{

    List<Float> prices = new ArrayList<>();

    @When("user fills in checkout form")
    public void user_fills_in_checkout_form() {
        sauceDemoCheckoutPage.fillCheckoutForm(MiscellaneousApplicationUtilities.generateNames(10),
                MiscellaneousApplicationUtilities.generateNames(10), MiscellaneousApplicationUtilities.generatePostalCode(8)
        ,1500);
    }

    @Then("user validates total price")
    public void user_validates_total_price() {
        prices = sauceDemoCheckoutPage.returnPriceList();
        Assert.assertTrue(sauceDemoCheckoutPage.validatePriceList(prices, SauceDemoProductsPage.listOfPricesInCart));
    }
}
