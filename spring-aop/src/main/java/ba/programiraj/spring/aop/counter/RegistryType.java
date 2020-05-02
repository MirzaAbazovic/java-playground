package ba.programiraj.spring.aop.counter;

public enum RegistryType {
    CALL("CALLS"),
    HANGUP_CAUSE("HANGUP_CAUSE");

    private final String value;

    RegistryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


}
