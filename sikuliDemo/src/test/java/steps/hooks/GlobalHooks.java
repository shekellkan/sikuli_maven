package steps.hooks;

import ui.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * User: Miguel Terceros
 * Date: 15/04/16
 */
public class GlobalHooks {
    private WebDriver webDriver;
    public GlobalHooks() {
        webDriver = DriverManager.getInstance().getWebDriver();
    }

    @After(order = 100000)
    public void ScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenShot...
            final byte[] screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png"); // ... and embed it in the report.
        }
    }
}
