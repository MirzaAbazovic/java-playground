package ba.programiraj.blog.java.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        Calculator blueCalculator = new BlueCalculator();

        final Calculator proxiedCalculator = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[]{Calculator.class},//or
                new CalculatorProxy(blueCalculator)
        );

        System.out.println("Proxied multiplication result = " + proxiedCalculator.multiply(2, 3));
        System.out.println("Proxied adding result = " + proxiedCalculator.add(2, 3));
        System.out.println("Proxied increment result = " + proxiedCalculator.increment(5));

        final Calculator proxiedCalculatorUsingLambda = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                blueCalculator.getClass().getInterfaces(),
                (proxy, method, arguments) -> {
                    System.out.println("BEFORE");
                    Object result = method.invoke(blueCalculator, arguments);
                    System.out.println("AFTER");
                    return result;
                }
        );

        System.out.println("Proxied by lambda multiplication result  = " + proxiedCalculatorUsingLambda.multiply(2, 3));
        System.out.println("Proxied by lambda adding result = " + proxiedCalculatorUsingLambda.add(2, 3));
        System.out.println("Proxied by lambda increment result = " + proxiedCalculatorUsingLambda.increment(5));

    }
}
