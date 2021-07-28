package cucumber.steps;

import io.cucumber.java.en.When;
import salesforce.ui.PageTransporter;

public class NavigationSteps {

    @When("^I navigate to (.*?) page$")
    public void iNavigateToAFeaturePage(final String page) {
        PageTransporter.navigateToUrlByPageName(page);
    }

}
