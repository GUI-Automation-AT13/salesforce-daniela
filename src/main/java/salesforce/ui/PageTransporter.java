package salesforce.ui;

import static salesforce.Configuration.ConfigurationFile.getEnvVariables;

import core.selenium.DriverManager;
import salesforce.Configuration.ConfigurationFile;
import salesforce.Configuration.Ui.Url;
import salesforce.ui.pages.LegalEntitiesPage;
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
    public static void goToUrl(final String url) {
        DriverManager.getInstance().getDriver().navigate().to(url);
    }

    /**
     * Navigates to an url by it's page name.
     *
     * @param page String with page.
     */
    public static void navigateToUrlByPageName(final String page) {
        // get the url with the name
        String baseUrl = Url.BASE_URL.get();
        goToUrl(baseUrl.concat(String.format(Url.FEATURE_URL.get(), page)));
    }

    /**
     * Navigates to the Legal entities page.
     *
     * @return a LegalEntityPage.
     */
    public LegalEntitiesPage navigateToLegalEntityPage() {
        goToUrl(baseUrl.concat(ConfigurationFile.getEnvVariables("ENTITIES_URL")));
        return new LegalEntitiesPage();
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
