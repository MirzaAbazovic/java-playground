package ba.programiraj.spring.aop;

import ba.programiraj.spring.aop.counter.Counter;
import ba.programiraj.spring.aop.service.PersonService;
import ba.programiraj.spring.aop.service.PersonServiceImpl;
import ba.programiraj.spring.aop.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
                final PersonService personService = ctx.getBean(PersonServiceImpl.class);
                checkIsPersonAlive(personService);
                log.info("Ping with Hello -> {}", personService.ping("Hello"));
                log.info("Ping with null -> {}", personService.ping(null));
                Counter counter = (Counter) personService;

                final String simpleName = Common.getPureSimpleName(personService.getClass().getSimpleName());
                Method[] allMethods = PersonService.class.getDeclaredMethods();

                for (Method method : allMethods) {
                    if (Modifier.isPublic(method.getModifiers())) {
                        final Long callCount = counter.getCount(simpleName, method.getName());
                        log.info("Method {} ping called count: {}", method.getName(), callCount);
                    }
                }


                personService.isPersonAlive(null);
                log.info("END");

            } catch (Exception e) {
                log.error("Error in app");
            }

        };
    }

    private void checkIsPersonAlive(PersonService personService) {
        final String personId = UUID.randomUUID().toString();
        log.info("Is person with id {} live", personId);
        final boolean isAlive = personService.isPersonAlive(personId);
        String liveDead = isAlive ? "live" : "dead";
        log.info("Person with {} is {} {}", personId, liveDead, System.lineSeparator());
    }

}
