package utilities;

import org.openqa.selenium.WebDriver;

public class MiscWebDriverUtilities {

    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
}
