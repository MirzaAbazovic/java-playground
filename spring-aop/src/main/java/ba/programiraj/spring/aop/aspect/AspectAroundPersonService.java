package ba.programiraj.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class AspectAroundPersonService {

    private static final Logger log = LoggerFactory.getLogger(AspectAroundPersonService.class);

    @Pointcut("within(ba.programiraj..*) && @annotation(ba.programiraj.spring.aop.annotation.Measurable)")
    public void measurableMethods() {
    }

    @Pointcut("within(ba.programiraj..*) && @annotation(ba.programiraj.spring.aop.annotation.Exceptionless)")
    public void exceptionlessMethods() {

    }

    @Around("measurableMethods()")
    public Object aroundMeasurableMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
        final Object result = proceedingJoinPoint.proceed();
        long endTime = System.nanoTime();
        log.info("Method {} took {} ms", proceedingJoinPoint.getSignature().getName(), TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
        return result;
    }

    @AfterThrowing(value = "exceptionlessMethods()", throwing = "ex")
    public void doOnException(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String stuff = signature.toString();
        String arguments = Arrays.toString(joinPoint.getArgs());
        log.error("ERROR handled in aspect Exception in method:{} with arguments {} " +
                "\nand the full toString: {} The exception is:", methodName, arguments, stuff, ex);
    }


}
