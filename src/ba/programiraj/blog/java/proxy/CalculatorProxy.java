package ba.programiraj.blog.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorProxy implements InvocationHandler {

    Object calculator;

    public CalculatorProxy(Object calculator) {
        this.calculator = calculator;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        //let us slowdown method multiply :P
        if (method.getName().equals("multiply")) {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {

            }
        }
        Object result = method.invoke(calculator, args);
        System.out.println("Executed method " + method.getName() + " with args: " + Arrays.deepToString(args)
                + " in " + (System.nanoTime() - startTime) / 1000 + " microseconds");
        return result;
    }
}
