package constants;

public enum PageNames {

    HOME("Home"),
    ACCOUNTS("Accounts");

    private String value;

    PageNames(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
