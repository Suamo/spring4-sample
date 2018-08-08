package ua.antonio.spring4sample.domain.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class JavaConfigLifecycleBean implements InitializingBean, DisposableBean {
    private List<String> initSequence = new ArrayList<>();

    @PostConstruct
    public void postConstructMethod() {
        initSequence.add("'before initialization' BeanPostProcessor (@PostConstruct)");
        System.out.println("-> Step 1. Bean Factory: calling init methods through 'before initialization' BeanPostProcessor (@PostConstruct)");
    }

    @Override
    public void afterPropertiesSet() {
        initSequence.add("InitializingBean.afterPropertiesSet");
        System.out.println("-> Step 2. Bean Factory: calling init methods (InitializingBean.afterPropertiesSet call - an alternative to initMethod attribute)");
    }

    public void initMethod() {
        initSequence.add("initMethod attribute");
        System.out.println("-> Step 3. Bean Factory: calling 'custom' init methods (initMethod attribute)");
    }

    @PreDestroy
    public void preDestroyMethod() {
        initSequence.add("'before destroy' BeanPostProcessor (@PreDestroy)");
        System.out.println("-> Step 4. Bean Factory: calling init methods through 'before destroy' BeanPostProcessor (@PreDestroy)");
    }

    @Override
    public void destroy() {
        initSequence.add("DisposableBean.destroy");
        System.out.println("-> Step 5. Bean Factory: destroy beans (DisposableBean.destroy call - an alternative to destroyMethod attribute)");
    }

    public void destroyMethod() {
        initSequence.add("destroyMethod attribute");
        System.out.println("-> Step 6. Bean Factory: calling 'custom' destroy methods (destroyMethod attribute)");
    }

    public List<String> getInitSequence() {
        return initSequence;
    }
}
