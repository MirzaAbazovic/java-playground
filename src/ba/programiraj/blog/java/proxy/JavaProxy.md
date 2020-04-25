
[Dynamic Proxy Classes](https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html)

Here we have [BlueCalculator](implementation/BlueCalculator.java) that implements 2 interfaces 
[Calculator](interfaces/Calculator.java) & [ScientificCalculator](interfaces/ScientificCalculator.java).

"A dynamic proxy class can be used to create a type-safe proxy object for a list of interfaces without requiring 
pre-generation of the proxy class, such as with compile-time tools."

We can do this by creating class (proxy) [CalculatorProxy](proxy/CalculatorProxy.java) or [CalculatorProxyFacotry](proxy/CalculatorProxyFactory.java) 
that implements ```InvocationHandler``` and holds reference to proxied object, or by using [lambda](Main.java##L26).

InvocotionHandler has invoke where you can do pre and post actions on object - or change return result (override method).

```java
package java.lang.reflect;

public interface InvocationHandler {
    Object invoke(Object var1, Method var2, Object[] var3) throws Throwable;
}
```

To create proxy use ```Proxy.newProxyInstance``` from ```java.lang.reflect```


```java
Calculator blueCalculator = new BlueCalculator();

Object proxiedCalculator = Proxy.newProxyInstance(
    Calculator.class.getClassLoader(),
    new Class[]{Calculator.class, ScientificCalculator.class},
    new CalculatorProxy(blueCalculator));
```
