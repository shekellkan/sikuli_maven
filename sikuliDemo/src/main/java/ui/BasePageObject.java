package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Miguel Terceros on 7/20/2016.
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected DriverManager driverManager;
    /**
     * Initializes the web driver, wait and web elements
     */
    public BasePageObject() {
        driverManager = DriverManager.getInstance();
        this.driver = DriverManager.getInstance().getWebDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public abstract void waitUntilPageObjectIsLoaded();

    /**
     * the isPresent method returns true if the element By is present
     * otherwise return false
     */
    public boolean isPresent(By by)
    {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e)
        {
            return false;
        }
    }

    /**
     * return true if the element is deleted after a number of tries
     * @param numberOfTries
     * @param by
     * @return
     */
    public boolean isDeleted(int numberOfTries, By by)
    {

        boolean isDeleted = false;
        int count = 0;
        while(count!=numberOfTries)
        {
            count++;
            try {
                Thread.sleep(200);
            }catch (Exception e){
                System.out.println("Sleep fails: "+e);
            }

            if(!isPresent(by)){
                isDeleted =  true;
                count= numberOfTries;
            }
        }
        return isDeleted;
    }

    /**
     * return true if the element is displayed after X seconds of searching it
     * @param by
     * @return
     */
    public boolean isDisplayed(By by)
    {
        boolean isDisplayed;
        try {
            driverManager.setImplicitWait(3);
            driver.findElement(by);
            isDisplayed = true;
        }catch (Exception e)
        {
            isDisplayed = false;
        }finally{
            driverManager.setImplicitWait(driverManager.getImplicitWait());
        }
        return isDisplayed;
    }
}
