package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import salesforce.configuration.ConfigurationFile;

/**
 * Configures the web driver.
 */
public class DriverConfig {
    private String browser;
    private int implicitWait;
    private int explicitWait;
    private int waitSleep;
    private static DriverConfig instance;

    private DriverConfig() {
        initialize();
    }

    /**
     * Gets the web driver instance.
     *
     * @return a DriverConfig.
     */
    public static DriverConfig getInstance() {
        if (instance == null) {
            instance = new DriverConfig();
        }
        return instance;
    }

    /**
     * Initializes the web driver.
     */
    public void initialize() {
        browser = ConfigurationFile.getEnvVariables("browser");
        implicitWait = Integer.parseInt(ConfigurationFile.getEnvVariables("implicitTimeWait"));
        explicitWait = Integer.parseInt(ConfigurationFile.getEnvVariables("explicitTimeWait"));
        waitSleep = Integer.parseInt(ConfigurationFile.getEnvVariables("waitSleepTime"));
    }

    /**
     * Instances the driver.
     *
     * @return s WebDriver
     */
    public WebDriver instanceDriver() {
        WebDriver driver;
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        return driver;
    }

    public String getBrowser() {
        return browser;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public int getWaitSleep() {
        return waitSleep;
    }
}
