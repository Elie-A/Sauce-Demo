package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SauceDemoProductsSteps extends TestBase{

    @When("user selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String sortBy) {
        sauceDemoProductsPage.selectSortBy(sortBy);
    }

    @Then("items are sorted by {string} in {string} order")
    public void items_are_sorted_by_in_order(String sortBy, String order) {
        Assert.assertTrue(sauceDemoProductsPage.validateSortBy(sortBy, order), "Invalid sort by " + sortBy + " in " + order + " order");
    }
}
