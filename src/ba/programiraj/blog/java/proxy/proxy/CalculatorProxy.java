package ba.programiraj.blog.java.proxy.proxy;

import ba.programiraj.blog.java.proxy.interfaces.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorProxy implements InvocationHandler {

    private Object calculator;

    public CalculatorProxy(Object calculator) {
        this.calculator = calculator;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(calculator, args);
        System.out.println("Executed method " + method.getName() + " with args: " + Arrays.deepToString(args)
                + " in " + (System.nanoTime() - startTime) / 1000 + " microseconds");
        return result;
    }
}
