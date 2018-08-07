package ua.antonio.spring4sample.domain.types;

import org.springframework.beans.factory.FactoryBean;

public class ThreadFactoryBean implements FactoryBean<Thread> {
    @Override
    public Thread getObject() throws Exception {
        return Thread.currentThread();
    }

    @Override
    public Class<?> getObjectType() {
        return Thread.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
