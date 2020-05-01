package ba.programiraj.spring.aop.service;

import ba.programiraj.spring.aop.annotation.Exceptionless;
import ba.programiraj.spring.aop.annotation.Measurable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Measurable
    @Exceptionless
    public boolean isPersonAlive(String personId) {
        return personId.hashCode() % 2 == 0;
    }

    public String ping(String pong) {
        if (pong == null) {
            return "No nulls please. I hate NPE.";
        }
        log.info("inside 'ping' return received {}", pong);
        return pong;
    }
}
