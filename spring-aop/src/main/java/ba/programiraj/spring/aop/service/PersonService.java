package ba.programiraj.spring.aop.service;

import ba.programiraj.spring.aop.annotation.Measurable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Measurable
    public boolean isPersonAlive(String personId) {
        long startTime = System.nanoTime();
        log.info("START 'isPersonAlive' args: personId: {}", personId);

        final boolean isAlive = personId.hashCode() % 2 == 0;
        if (isAlive) {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                //Slowdown method

            }
        }

        log.info("END 'isPersonAlive' return: {}. Execution time {} ms", isAlive, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
        return isAlive;
    }

    public String ping(String pong) {
        if (pong == null) {
            return "No nulls please. I hate NPE.";
        }
        log.info("inside 'ping' return received {}", pong);
        return pong;
    }
}
