package ua.antonio.spring4sample.domain.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Bean Factory is a DefaultListableBeanFactory
 */
public class XmlConfigLifecycleBean implements InitializingBean, DisposableBean {
    private List<String> initSequence = new ArrayList<>();

    public XmlConfigLifecycleBean() {
        initSequence.add("constructor");
        System.out.println("-> Step 1. Bean Factory: instantiation (constructor call)");
    }

    public void setValue(String value) {
        initSequence.add("setter");
        System.out.println("-> Step 2. Bean Factory: processing property (setter)");
    }

    @Override
    public void afterPropertiesSet() {
        initSequence.add("InitializingBean.afterPropertiesSet");
        System.out.println("-> Step 3. Bean Factory: calling init methods (InitializingBean.afterPropertiesSet call - an alternative to init-method)");
    }

    public void initMethod() {
        initSequence.add("init-method");
        System.out.println("-> Step 4. Bean Factory: calling 'custom' init methods (init-method attribute)");
    }

    @Override
    public void destroy() {
        initSequence.add("DisposableBean.destroy");
        System.out.println("-> Step 5. Bean Factory: destroy beans (DisposableBean.destroy call - an alternative to destroy-method)");
    }

    public void destroyMethod() {
        initSequence.add("destroy-method");
        System.out.println("-> Step 6. Bean Factory: calling 'custom' destroy methods (destroy-method attribute)");
    }

    public List<String> getInitSequence() {
        return initSequence;
    }
}
