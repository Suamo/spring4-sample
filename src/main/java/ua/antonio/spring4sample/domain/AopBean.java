package ua.antonio.spring4sample.domain;

import java.util.List;

public interface AopBean {

    List<String> getActionsSequence();

    void validateName();
}
