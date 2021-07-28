package salesforce.configuration;

public enum Url {

    BASE_URL("https://freeorg01com-dev-ed.lightning.force.com/"),
    FEATURE_URL("lightning/o/%s/list?filterName=Recent");

    private String value;

    Url(final String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
