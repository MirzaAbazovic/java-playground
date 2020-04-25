package ba.programiraj.blog.java.proxy;

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
    public void drawFunction(Object input) {
        System.out.println("Draw function with input.toString() = " + input.toString());

    }
}
