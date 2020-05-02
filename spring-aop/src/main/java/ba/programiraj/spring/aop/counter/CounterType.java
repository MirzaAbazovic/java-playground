package ba.programiraj.spring.aop.counter;

public enum CounterType {
    CALLER_HANGUP("CALLER_HANGUP"),
    NORMAL_CLEARING("NORMAL_CLEARING"),

    CALL_ESTABLISHED("CALL_ESTABLISHED"),
    CALL_DROPPED("CALL_DROPPED");

    private final String value;

    CounterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
