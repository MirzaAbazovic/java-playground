package ba.programiraj.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
    public boolean isPersonAlive(String personId) {
        log.info("Start method isPersonAlive");
        log.info("personId = " + personId);
        final boolean isAlive = personId.hashCode() % 2 == 0;
        return isAlive;
    }

}
