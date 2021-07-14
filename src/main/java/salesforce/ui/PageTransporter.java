package salesforce.ui;

import static salesforce.configuration.ConfigurationFile.getEnvVariables;

import core.selenium.DriverManager;
import salesforce.configuration.ConfigurationFile;
import salesforce.ui.pages.LegalEntityPage;
import salesforce.ui.pages.LoginPage;

/**
 * Navigates to an specified url.
 */
public class PageTransporter {

    private String baseUrl = getEnvVariables("BASE_URL");

    /**
     * Got to the specified url.
     *
     * @param url string with the url.
     */
    public void goToUrl(final String url) {
        DriverManager.getInstance().getDriver().navigate().to(url);
    }

    /**
     * Navigates to the Legal entities page.
     *
     * @return a LegalEntityPage.
     */
    public LegalEntityPage navigateToLegalEntityPage() {
        goToUrl(baseUrl.concat(ConfigurationFile.getEnvVariables("ENTITIES_URL")));
        return new LegalEntityPage();
    }

    /**
     * Navigates to the login page.
     *
     * @return a LoginPage.
     */
    public LoginPage navigateToLoginPage() {
        goToUrl(baseUrl);
        return new LoginPage();
    }

}
