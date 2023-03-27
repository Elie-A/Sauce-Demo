package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestBase {

    @After
    public void tearDownScenario(Scenario name) {
        System.out.println("========After Scenario===========");
        System.out.println("Name : " + name.getName());
        System.out.println(name.getSourceTagNames());
        try {
            if (name.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) sauceDemoDriver).getScreenshotAs(OutputType.BYTES);
                name.attach(screenshot, "image/png", name.getName());
            }
        } catch (Exception e) {
            name.log("WARNING. Failed to take screenshot with following exception : " + e.getMessage());
            System.out.println(e);
        }
    }
}
