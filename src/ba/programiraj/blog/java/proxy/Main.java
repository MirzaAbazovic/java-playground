package ba.programiraj.blog.java.proxy;

import ba.programiraj.blog.java.proxy.implementation.BlueCalculator;
import ba.programiraj.blog.java.proxy.interfaces.Calculator;
import ba.programiraj.blog.java.proxy.interfaces.ScientificCalculator;
import ba.programiraj.blog.java.proxy.proxy.CalculatorProxy;
import ba.programiraj.blog.java.proxy.proxy.CalculatorProxyFactory;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        Calculator blueCalculator = new BlueCalculator();

        Object proxiedCalculator =  Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[]{Calculator.class, ScientificCalculator.class},
                new CalculatorProxy(blueCalculator)
        );

        printResult((Calculator) proxiedCalculator);
        printFunction((ScientificCalculator) proxiedCalculator);

        Object proxiedCalculatorUsingLambda =  Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                blueCalculator.getClass().getInterfaces(), // same as new Class[]{Calculator.class, ScientificCalculator.class}
                (proxy, method, arguments) -> {
                    System.out.println("BEFORE: " + method.getName() );
                    Object result = method.invoke(blueCalculator, arguments);
                    System.out.println("AFTER:" + method.getName());
                    return result;
                }
        );

        printResult((Calculator) proxiedCalculatorUsingLambda);
        printFunction((ScientificCalculator) proxiedCalculatorUsingLambda);


        Object calculatorLast =  CalculatorProxyFactory.newInstance(blueCalculator);


        printResult((Calculator) calculatorLast);
        printFunction((ScientificCalculator) calculatorLast);


    }

    private static void printResult(Calculator calculator) {
        System.out.println("**********************************************************");
        System.out.println("Multiplication result  = " + calculator.multiply(2, 3));
        System.out.println("Adding result = " + calculator.add(2, 3));
        System.out.println("Increment result = " + calculator.increment(5));
        System.out.println("**********************************************************");
    }
    private static void printFunction(ScientificCalculator calculator) {
        System.out.println("**********************************************************");
        calculator.drawFunction("x=f(x)");
        System.out.println("**********************************************************");
    }
}
