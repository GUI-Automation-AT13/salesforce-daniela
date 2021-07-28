package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LegalEntityHooks {

    @Before(value = "@CreateLegalEntity")
    public void setUp() {

    }

    @After(value = "@CreateLegalEntity")
    public void setDown() {
    }
}
