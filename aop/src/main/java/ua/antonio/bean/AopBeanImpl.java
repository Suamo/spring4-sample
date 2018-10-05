package ua.antonio.bean;

import java.util.ArrayList;
import java.util.List;

public class AopBeanImpl implements AopBean {
    private List<String> actionsSequence = new ArrayList<>();

    public void addAction(String action) {
        actionsSequence.add(action);
    }

    @Override
    public List<String> getActionsSequence() {
        return actionsSequence;
    }

    @Override
    public void validateName() {
        actionsSequence.add("Target method call");
    }

    @Override
    public void callMethodWithException() {
        actionsSequence.add("Exception method call");
        throw new RuntimeException("RuntimeException for testing advices.");
    }

}
