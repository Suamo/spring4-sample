package ua.antonio.bean;

import java.util.ArrayList;
import java.util.List;

public class SomePojo {
    private String customValue;
    private List<String> actionsSequence = new ArrayList<>();

    public void addAction(String action) {
        actionsSequence.add(action);
    }

    public List<String> getActionsSequence() {
        return actionsSequence;
    }

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }
}
