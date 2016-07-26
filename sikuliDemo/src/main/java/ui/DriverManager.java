package ui;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager instance;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static int implicitWait;
    private static int explicitWait;

    protected DriverManager(){
    }

    public static DriverManager getInstance()
    {
        if(instance == null)
        {
            implicitWait = 30;
            explicitWait = 40;
            instance = new DriverManager();
            if(driver == null)
            {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quit()
    {
        driver.quit();
        driver = null;
    }
    public int getImplicitWait(){return implicitWait;}
    public void setImplicitWait(int implicitSecondTime) {driver.manage().timeouts().implicitlyWait(implicitSecondTime, TimeUnit.SECONDS);}
}
