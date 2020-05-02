# Spring AOP

[Aspect Oriented Programming (AOP) with Spring](https://docs.spring.io/spring/docs/5.2.5.RELEASE/spring-framework-reference/core.html#aop)

## Aspect

Modularization of s concern that cuts across multiple classes. Class that implements the application concerns(logic) which cut through multiple classes: logging, transaction management, security, etc.
Aspects can be a normal class **configured through Spring XML configuration**.
It can also be regular classes **annotated using @Aspect annotation.**

## Advice

Something to be executed on (before, after, around) some place (jointpoint) if defined by some expresion (pointcut). :). Action taken by aspect at join point.

## Joinpoint

A possible **point in the program** execution where an **aspect can be plugged in** (some place). A point of execution in the program to connect the Aspect.
It could be a method that is being called, an exception being thrown, or even a field being modified, constructor etc. **In Spring this can only be method.**

## Pointcut

An **expression** that is matched with **join points** to determine whether **advice** needs **to be executed** or not.

One or more join points where advice should be executed.

**Predicate or expression** that matches join points

## Target Object

Objects on which advices are applied. In Spring AOP, a subclass is created at runtime where the target method is overridden
and advices are included based on their configuration.

## Proxy

It is an object that is created after applying advice to the target object.
In clients perspective, object, the target object, and the proxy object are same.

## Weaving

Process of linking an aspect with other application types or objects to create an advised object.

## Types of Advices

Several types of advices present in Spring AOP are as follows:

1. Before
2. After returning
3. After throwing
4. After (finally)
5. Around

**Before** - Here, advices execute before the joinpoint methods and are configured using **@Before** annotation mark. Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).

**After returning** - These advice types execute after the joinpoint methods complete the execution normally. They are configured using **@AfterReturning** annotation mark. Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception.

**After throwing** - Here, advices execute only when the joinpoint method exits by throwing an exception. They are configured using **@AfterThrowing** annotation mark.

**After (finally)** -> In this case, advices execute after a joinpoint method executes, regardless of the method’s exit (whether normal or exceptional return). They are configured using **@After** annotation mark.

**Around** -> These advice types execute before and after a join point and are configured using **@Around** annotation mark. Most powerful kind of advice. Around advice **can perform custom behavior before and after the method invocation**. It is also responsible for **choosing whether to proceed** to the join point or to **shortcut the advised method execution** by returning its own return value or **throwing an exception**.
