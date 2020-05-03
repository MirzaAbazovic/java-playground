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
    public void incCounter(String registryType, String counterType) {
        incCounter(registryType, counterType, 1L);
    }

    @Override
    public synchronized void incCounter(String registryType, String counterType, Long incValue) {
        final String countKey = getCountKey(registryType, counterType);
        final Long countValue = counters.get(countKey);
        if (countValue == null) {
            counters.put(countKey, incValue);
        } else {
            counters.put(countKey, countValue + incValue);
        }
    }

    @Override
    public Long getCount(String registryType, String counterType) {
        final String countKey = getCountKey(registryType, counterType);
        return counters.get(countKey);
    }

    private String getCountKey(String registryType, String counterType) {
        return registryType + "$$" + counterType;
    }
}
