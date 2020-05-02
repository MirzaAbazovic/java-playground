package ba.programiraj.spring.aop.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CounterImpl implements Counter {
    private static Logger log = LoggerFactory.getLogger(CounterImpl.class);
    private static Map<String, Long> counters;
    public CounterImpl() {
        counters = new HashMap<>();
    }

    @Override
    public void incCounter(RegistryType registryType, CounterType counterType) {
        incCounter(registryType, counterType, 1L);
    }

    @Override
    public synchronized void incCounter(RegistryType registryType, CounterType counterType, Long incValue) {
        final String countKey = registryType.getValue() + "|" + counterType.getValue();
        final Long countValue = counters.get(countKey);
        if (countValue == null) {
            counters.put(countKey, incValue);
        } else {
            counters.put(countKey, countValue + incValue);
        }
        log.info("For registry {} counter type {} is {}", registryType, counterType, counters.get(countKey));
    }
}
