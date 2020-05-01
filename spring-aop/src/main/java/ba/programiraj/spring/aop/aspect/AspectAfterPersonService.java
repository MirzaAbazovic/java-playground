package ba.programiraj.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AspectAfterPersonService {

    private static Logger log = LoggerFactory.getLogger(AspectAfterPersonService.class);

    @AfterReturning(pointcut = "execution(* ba.programiraj.spring.aop.service.PersonService.*(..))", returning = "result")
    public void afterEveryMethodInPersonService(JoinPoint joinPoint, Object result) {
        log.info("AFTER 'isPersonAlive' method {} in {} | args {} | returned: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName(),
                Arrays.toString(joinPoint.getArgs()),
                result);

    }

}
