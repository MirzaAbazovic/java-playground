package ba.programiraj.blog.java.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxyFactory implements InvocationHandler {

    private Object calculator;

    private CalculatorProxyFactory(Object calculator) {
        this.calculator = calculator;
    }

    public static Object newInstance(Object calculator) {
        return Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                new CalculatorProxyFactory(calculator));
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("Before method " + method.getName() + " with args = " + Arrays.deepToString(args));
        Object result;
        try {
            result = method.invoke(calculator, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            System.out.println("Method finished");
        }
        return result;
    }
}
