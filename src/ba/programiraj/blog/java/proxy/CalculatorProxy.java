package ba.programiraj.blog.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CalculatorProxy implements InvocationHandler {

    Object calculator;

    public CalculatorProxy(Object calculator) {
        this.calculator = calculator;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(calculator, args);
        final String argsJoined = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(","));
        System.out.println("Executed method " + method.getName() + " with args: " + argsJoined
                + " in " + (System.nanoTime() - startTime) + " nanoseconds");
        return result;
    }
}
