package salesforce.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import static salesforce.Configuration.ConfigurationFile.getEnvVariables;

public class Internationalization {

    private static final String LEGAL_ENTITY = "internationalization/i18NLegalEntities";

    /**
     * Translates to a language.
     *
     * @param key a string with the field to be translated.
     * @return a string with the translation.
     */
    public static String translate(final String key) {
        return ResourceBundle.getBundle(LEGAL_ENTITY, getLanguage()).getString(key);
    }

    /**
     * Gets the internationalization language.
     *
     * @return Locale with language.
     */
    public static Locale getLanguage() {
        return new Locale(getEnvVariables("language"));
    }

}
