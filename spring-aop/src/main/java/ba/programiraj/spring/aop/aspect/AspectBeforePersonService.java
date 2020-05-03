
package ba.programiraj.spring.aop.aspect;

import ba.programiraj.spring.aop.counter.Counter;
import ba.programiraj.spring.aop.util.Common;
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

    @Before("execution(* ba.programiraj.spring.aop.service.PersonServiceImpl.*(..))")
    public void beforeAllMethodsInPersonService(JoinPoint joinPoint) {
        final String methodName = joinPoint.getSignature().getName();
        log.info("BEFORE every method {} in {} | args {}",
                methodName,
                joinPoint.getTarget().getClass().getSimpleName(),
                Arrays.toString(joinPoint.getArgs()));
        Counter counter = (Counter) joinPoint.getThis();
        counter.incCounter(Common.getPureSimpleName(joinPoint.getThis().getClass().getSimpleName()), methodName);
    }


    @Before("execution(* ba.programiraj.spring.aop.service.PersonServiceImpl.isPersonAlive*(..))")
    public void beforeIsPersonAliveInPersonService(JoinPoint joinPoint) {
        log.info("BEFORE 'isPersonAlive' method {} in {} | args {}",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName(),
                Arrays.toString(joinPoint.getArgs()));
    }


}
