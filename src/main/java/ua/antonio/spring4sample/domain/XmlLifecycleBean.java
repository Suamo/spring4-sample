package ua.antonio.spring4sample.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Default Bean Factory is a DefaultListableBeanFactory
 */
public class XmlLifecycleBean implements InitializingBean, DisposableBean {
    private String value;

    public XmlLifecycleBean() {
        System.out.println("-> Step 1. Bean Factory: instantiation (constructor call)");
    }

    public void setValue(String value) {
        System.out.println("-> Step 2. Bean Factory: processing property (setter)");
        this.value = value;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("-> Step 3. Bean Factory: calling init methods (InitializingBean.afterPropertiesSet call - an alternative to init-method)");
    }

    public void initMethod() {
        System.out.println("-> Step 4. Bean Factory: calling 'custom' init methods (init-method attribute)");
    }

    @Override
    public void destroy() {
        System.out.println("-> Step 5. Bean Factory: destroy beans (DisposableBean.destroy call - an alternative to destroy-method)");
    }

    public void destroyMethod() {
        System.out.println("-> Step 6. Bean Factory: calling 'custom' destroy methods (destroy-method attribute)");
    }

}
