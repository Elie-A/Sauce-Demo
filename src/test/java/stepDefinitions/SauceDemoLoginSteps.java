package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.DriverManager;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoLoginSteps extends TestBase{

    boolean driverInstanceRunning = false;
    List<String> credentials = new ArrayList<>();

    @Given("user logs in to sauce demo with {string} credentials")
    public void user_logs_in_to_sauce_demo_with_credentials(String loginAs) throws Exception{
        navigateToSauceDemo();

        credentials = parsers.getCredentials(DriverManager.externalDataProperties.getProperty("login_file_name"), loginAs, "username", "password");
        sauceDemoLoginPage.enterUsername(credentials.get(0));
        sauceDemoLoginPage.enterPassword(credentials.get(1));
        sauceDemoLoginPage.clickLogin(1500);
    }

    @Then("user is on the {string} page")
    public void user_is_on_the_page(String page) {
        switch (page){
            case "Products":
                Assert.assertTrue(sauceDemoLoginPage.isOnProductsPage(page), "User is not on " + page + " page");
                break;
            case "Your Cart":
                Assert.assertTrue(sauceDemoCartPage.isOnCartPage(page), "User is not on " + page + " page");
                break;
            case "Checkout: Your Information":
                Assert.assertTrue(sauceDemoCheckoutPage.isOnCheckoutPage(page), "User is not on " + page + " page");
                break;
            case "Checkout: Overview":
                Assert.assertTrue(sauceDemoCheckoutOverviewPage.isOnCheckoutOverviewPage(page), "User is not on " + page + " page");
                break;
            case "Checkout: Complete!":
                Assert.assertTrue(sauceDemoCheckoutCompletePage.isOnCheckoutCompletePage(page), "User is not on " + page + " page");
                break;

            default:
                System.out.println("Invalid page");
                break;
        }
    }

    @Given("driver instance is running")
    public void driverInstanceIsRunning() {
        driverInstanceRunning = sauceDemoLoginPage.isDriverRunning();
    }

    @Then("user kills driver instance")
    public void userKillsDriverInstance() {
        sauceDemoLoginPage.killDriver(driverInstanceRunning);
    }

}
