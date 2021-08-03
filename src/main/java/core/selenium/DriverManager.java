package core.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.Configuration.ConfigurationFile;

/**
 * Manages and initializes the browser drivers.
 */
public class DriverManager {

    public WebDriver driver;
    public DriverConfig driverConfig = DriverConfig.getInstance();
    public static DriverManager driverManager;
    public WebDriverWait webDriverWait;

    private DriverManager() {
        initialize();
    }

    /**
     * Gets the driver of the given driver.
     *
     * @return a WebDriver.
     */
    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
            System.out.println("=======================> " + driverManager);
        }
        return driverManager;
    }

    /**
     * Initializes the web driver.
     */
    public void initialize() {
        driverConfig = DriverConfig.getInstance();
        DriverManagerType driverManagerType = DriverManagerType.valueOf(ConfigurationFile.getEnvVariables("browser"));
        WebDriverManager.getInstance(driverManagerType).setup();
        driver = driverConfig.instanceDriver();
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
        driverManager = null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
