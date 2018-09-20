package ua.antonio.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

    private SimpleBean2 child;

    public SimpleBean2 getChild() {
        return child;
    }

    @Autowired
    public void setChild(SimpleBean2 child) {
        this.child = child;
    }

}
