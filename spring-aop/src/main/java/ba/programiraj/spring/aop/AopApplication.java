package ba.programiraj.spring.aop;

import ba.programiraj.spring.aop.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.UUID;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {
    private static final Logger log = LoggerFactory.getLogger(AopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            try {
                final PersonService personService = ctx.getBean(PersonService.class);
                randomPerson(personService);
                log.info("Ping with Hello -> {}", personService.ping("Hello"));
                log.info("Ping with null -> {}", personService.ping(null));
                personService.isPersonAlive(null);
                log.info("END");
            } catch (Exception e) {
                log.error("Error in app");
            }

        };
    }

    private void randomPerson(PersonService personService) {
        final String personId = UUID.randomUUID().toString();
        log.info("Is person with id {} live", personId);
        final boolean isAlive = personService.isPersonAlive(personId);
        String liveDead = isAlive ? "live" : "dead";
        log.info("Person with {} is {} {}", personId, liveDead, System.lineSeparator());
    }

}
