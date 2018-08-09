package ua.antonio.spring4sample.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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

}
