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
        System.out.println("-> Step 2. Bean Factory: calling init methods (InitializingBean.afterPropertiesSet call - an alternative to initMethod attribute)");
    }

    public void initMethod() {
        System.out.println("-> Step 3. Bean Factory: calling 'custom' init methods (initMethod attribute)");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("-> Step 4. Bean Factory: calling init methods through 'before destroy' BeanPostProcessor (@PreDestroy used)");
    }

    @Override
    public void destroy() {
        System.out.println("-> Step 5. Bean Factory: destroy beans (DisposableBean.destroy call - an alternative to destroyMethod attribute)");
    }

    public void destroyMethod() {
        System.out.println("-> Step 6. Bean Factory: calling 'custom' destroy methods (destroyMethod attribute)");
    }
}
