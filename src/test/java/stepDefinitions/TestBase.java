package stepDefinitions;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.SauceDemoLoginPage;
import pageObjects.SauceDemoMenuPage;
import pageObjects.SauceDemoProductsPage;
import utilities.applicationUtilities.Parsers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TestBase {

    public static WebDriver sauceDemoDriver;
    private static String baseURL;

    private static Logger LOGGER = LogManager.getLogger(DriverManager.class);

    public static SauceDemoLoginPage sauceDemoLoginPage;
    public static SauceDemoMenuPage sauceDemoMenuPage;
    public static SauceDemoProductsPage sauceDemoProductsPage;
    public static Parsers parsers = new Parsers();

    public static void navigateToSauceDemo() throws Exception {
        sauceDemoDriver = DriverManager.getSauceDemoDriver();
        initiateSauceDemoPages();
        baseURL = DriverManager.properties.getProperty("url");
        sauceDemoDriver.get(baseURL);
    }

    private static void initiateSauceDemoPages() throws Exception {
        sauceDemoLoginPage = new SauceDemoLoginPage(sauceDemoDriver);
        sauceDemoMenuPage = new SauceDemoMenuPage(sauceDemoDriver);
        sauceDemoProductsPage = new SauceDemoProductsPage(sauceDemoDriver);
        DriverManager.populateMap();
    }
}