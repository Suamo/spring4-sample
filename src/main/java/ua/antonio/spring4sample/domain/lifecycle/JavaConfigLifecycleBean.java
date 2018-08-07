package ua.antonio.spring4sample.domain.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JavaConfigLifecycleBean implements InitializingBean, DisposableBean {
    private String value;

    @PostConstruct
    public void postConstructMethod() {
        System.out.println("-> Step 1. Bean Factory: calling init methods through 'before initialization' BeanPostProcessor (@PostConstruct used)");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("-> Step 2. Bean Factory: calling init methods (InitializingBean.afterPropertiesSet call - an alternative to initMethod)");
    }

    public void initMethod() {
        System.out.println("-> Step 3. initMethod");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("-> Step 4. @PreDestroy");
    }

    @Override
    public void destroy() {
        System.out.println("-> Step 5. destroy");
    }

    public void destroyMethod() {
        System.out.println("-> Step 6. destroyMethod");
    }
}
