package cucumber.steps;

import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.ui.PageTransporter;

public class NavigationSteps {

    private Logger logger = LogManager.getLogger(getClass());

    @When("^I navigate to (.*?) page$")
    public void iNavigateToAFeaturePage(final String page) {
        logger.info("=================== When I navigate to a feature page ==========================");
        PageTransporter.navigateToUrlByPageName(page);
    }

}
