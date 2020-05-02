package ba.programiraj.spring.aop.counter;

public interface Counter {
    void incCounter(RegistryType registryType, CounterType counterType);

    void incCounter(RegistryType registryType, CounterType counterType, Long incValue);
}
