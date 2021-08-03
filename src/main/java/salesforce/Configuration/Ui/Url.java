package salesforce.Configuration.Ui;

public enum Url {

    BASE_URL("https://freeorg01com-dev-ed.lightning.force.com/"),
    FEATURE_URL("lightning/o/%s/list?filterName=Recent");

    private String value;

    Url(final String incomingValue) {
        this.value = incomingValue;
    }

    public void setValue(final String incomingValue) {
        this.value = incomingValue;
    }

    public String get() {
        return value;
    }
}
