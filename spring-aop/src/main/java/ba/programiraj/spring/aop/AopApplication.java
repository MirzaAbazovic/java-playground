package ba.programiraj.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {
    private static final Logger log = LoggerFactory.getLogger(AopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            final PersonService personService = ctx.getBean(PersonService.class);
            final String personId = "XYY";
            log.info("Is person with id {} live", personId);
            final boolean isAlive = personService.isPersonAlive(personId);
            String liveDead = isAlive ? "live" : "dead";
            log.info("Person with {} is {}", personId, liveDead);


        };
    }

}
