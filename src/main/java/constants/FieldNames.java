package constants;

public enum FieldNames {

    NAME("Name"),
    PHONE("Phone");

    private String value;

    FieldNames(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
