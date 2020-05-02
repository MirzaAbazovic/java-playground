package ba.programiraj.spring.aop.aspect;

import ba.programiraj.spring.aop.counter.Counter;
import ba.programiraj.spring.aop.counter.CounterImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDeclareParents {

    private static Logger log = LoggerFactory.getLogger(AspectDeclareParents.class);
//
    @DeclareParents(value = "ba.programiraj.spring.aop.service..*", defaultImpl = CounterImpl.class)
    public static Counter counter;

//    @Before("ba.programiraj.spring.aop.service.PersonService() && this(ba.programiraj.spring.aop.counter.Counter)")
//    public void count(Counter counter, RegistryType registryType, CounterType counterType) {
//        counter.incCounter(registryType, counterType);
//    }

}
