
package ba.programiraj.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AspectBeforePersonService {

    private static Logger log = LoggerFactory.getLogger(AspectBeforePersonService.class);

    @Before("execution(* ba.programiraj.spring.aop.service.PersonService.*(..))")
    public void beforePersonServiceAllMethods(JoinPoint joinPoint){

        log.info("Before method {} in {} | args {}",
                joinPoint.getSignature().getName() ,
                joinPoint.getTarget().getClass().getSimpleName(),
                Arrays.toString(joinPoint.getArgs()));
    }

}
