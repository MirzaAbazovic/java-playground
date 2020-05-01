package ba.programiraj.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class AspectAroundPersonService {

    private static final Logger log = LoggerFactory.getLogger(AspectAroundPersonService.class);

    @Pointcut("within(ba.programiraj..*) && @annotation(ba.programiraj.spring.aop.annotation.Measurable)")
    public void measurableMethods() {
    }

    @Around("measurableMethods()")
    public Object aroundIsPersonAliveInPersonService(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.nanoTime();
        final Object result = pjp.proceed();
        long endTime = System.nanoTime();
        log.info("Method {} took {} ms", pjp.getSignature().getName(), TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
        return result;
    }

}
