package ua.antonio.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

    private SimpleBean2 child;

    private String javaVersion;
    private Double value;

    public SimpleBean2 getChild() {
        return child;
    }

    @Autowired
    public void setChild(SimpleBean2 child) {
        this.child = child;
    }

    @Value("${java.runtime.version}")
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    public void setValue(Double value) {
        this.value = value;
    }
}
