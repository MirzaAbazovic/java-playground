package ba.programiraj.spring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    public boolean isPersonAlive(String personId) {
        long startTime = System.nanoTime();
        log.info("START 'isPersonAlive' args: personId: {}", personId);

        final boolean isAlive = personId.hashCode() % 2 == 0;

        log.info("END 'isPersonAlive' return: {}. Execution time {} ms", isAlive, (System.nanoTime() - startTime) / 1000);
        return isAlive;
    }

    public String ping(String pong) {
        log.info("inside 'ping' return received {}", pong);
        return pong;
    }

}
