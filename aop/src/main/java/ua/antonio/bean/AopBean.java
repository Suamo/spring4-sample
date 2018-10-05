package ua.antonio.bean;

import java.util.Date;
import java.util.List;

public interface AopBean {

    List<String> getActionsSequence();

    void validateName();

    void callMethodWithException();

    void checkPointcut(int beforeValue, Long afterValue, Date date);
}
