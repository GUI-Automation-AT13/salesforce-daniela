package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Manages and initializes the browser drivers.
 */
public class DriverManager {

    public static WebDriver driver = null;
    public static String browser;

    private DriverManager() {
    }

    /**
     * Gets the driver of the given driver.
     *
     * @param browserDriver String with the type of driver.
     * @return a WebDriver.
     */
    public static WebDriver getDriver(final String browserDriver) {
        browser = browserDriver;
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
