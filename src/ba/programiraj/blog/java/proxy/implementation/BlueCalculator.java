package ba.programiraj.blog.java.proxy.implementation;

import ba.programiraj.blog.java.proxy.interfaces.Calculator;
import ba.programiraj.blog.java.proxy.interfaces.ScientificCalculator;

public class BlueCalculator implements Calculator, ScientificCalculator {
    @Override
    public int multiply(int first, int second) {
        return first * second;
    }

    @Override
    public int add(int first, int second) {
        return first + second;
    }

    @Override
    public int increment(int number) {
        return ++number;
    }

    @Override
    public void drawFunction(String input) {
        System.out.println("Draw function with input= " + input);

    }
}
