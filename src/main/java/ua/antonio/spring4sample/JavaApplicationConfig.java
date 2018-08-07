package ua.antonio.spring4sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.antonio.spring4sample.domain.lifecycle.JavaConfigLifecycleBean;

@Configuration
public class JavaApplicationConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public JavaConfigLifecycleBean xmlConfigLifecycleBean() {
        return new JavaConfigLifecycleBean();
    }
}
