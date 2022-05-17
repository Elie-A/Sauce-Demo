package managers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.MiscWebDriverUtilities;

import java.util.List;

public class PageObjectManager {
    protected final static Logger LOGGER = LogManager.getLogger(PageObjectManager.class);
    protected WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterText(WebElement element, String text){
        LOGGER.info("Typing " + text + " into " + element);
        element.sendKeys(text);
    }

    public void clickElement(WebElement element){
        LOGGER.info("Clicking " + element);
        element.click();
    }

    public void enterTextWithWait(WebElement element, String text, int msec){
        LOGGER.info("Typing " + text + " into " + element + " with wait " + msec + " milliseconds");
        try{
            element.sendKeys(text);
            Thread.sleep(msec);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void clickElementWithWait(WebElement element, int msec){
        LOGGER.info("Clicking " + element + " with wait " + msec + " milliseconds");
        try{
            element.click();
            Thread.sleep(msec);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean isElementDisplayed(List<WebElement> elements){
        LOGGER.info("Validating if element is displayed");
        return elements.size() > 0;
    }

    public void refreshPage(){
        try{
            Thread.sleep(2000);
            MiscWebDriverUtilities.refreshPage(driver);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void killDriverInstance(){
        LOGGER.info("Stopping web driver instance");
        if(driver != null){
            driver.close();
            driver.quit();
            LOGGER.info("Web driver instance stopped");
        }
    }
}
