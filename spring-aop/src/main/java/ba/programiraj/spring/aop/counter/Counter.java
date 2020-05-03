package ba.programiraj.spring.aop.counter;

public interface Counter {
    void incCounter(String registryType, String  counterType);

    void incCounter(String registryType, String counterType, Long incValue);

    Long getCount(String registryType, String  counterType);
}
