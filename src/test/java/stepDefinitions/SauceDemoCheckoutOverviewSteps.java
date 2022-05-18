package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import managers.DriverManager;
import org.testng.Assert;
import utilities.applicationUtilities.MiscellaneousApplicationUtilities;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCheckoutOverviewSteps extends TestBase{

    float expectedPrice = 0;
    List<Float> pricesList = new ArrayList<>();

    @Then("user validates total price with tax of {string}")
    public void user_validates_total_price_with_tax_of(String key) {
        pricesList = sauceDemoCheckoutPage.returnPriceList();
        expectedPrice = sauceDemoCheckoutOverviewPage.returnTotalPrice();

        float sum = MiscellaneousApplicationUtilities.returnSum(pricesList);
        float total = MiscellaneousApplicationUtilities.calculatePrice(Float.parseFloat(DriverManager.map.get(key).replace("%", "")), sum);
        Assert.assertTrue(sauceDemoCheckoutOverviewPage.validateTotalPrice(total, expectedPrice), "Invalid total: " + total + " expected: " + expectedPrice);
    }

    @And("user clicks on finish button")
    public void userClicksOnFinishButton() {
        sauceDemoCheckoutOverviewPage.clickFinishButton();
    }
}
