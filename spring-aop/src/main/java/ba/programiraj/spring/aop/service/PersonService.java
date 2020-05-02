package ba.programiraj.spring.aop.service;

public interface PersonService {

    boolean isPersonAlive(String personId);

    String ping(String pong);
}
