package ba.programiraj.spring.aop.aspect;

import ba.programiraj.spring.aop.counter.Counter;
import ba.programiraj.spring.aop.counter.CounterImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDeclareParents {

    @DeclareParents(value = "ba.programiraj.spring.aop.service..*", defaultImpl = CounterImpl.class)
    public static Counter counter;


}
