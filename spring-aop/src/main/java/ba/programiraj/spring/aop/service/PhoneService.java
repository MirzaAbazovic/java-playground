package ba.programiraj.spring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private static final Logger log = LoggerFactory.getLogger(PhoneService.class);

    public void call(String phoneNumber) {
        log.info("Calling {} ...", phoneNumber);

    }
}
