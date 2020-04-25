package ba.programiraj.blog.java.proxy;

public class BlueCalculator implements Calculator {
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
}
