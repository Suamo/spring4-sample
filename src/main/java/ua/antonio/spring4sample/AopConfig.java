package ua.antonio.spring4sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ua.antonio.spring4sample.domain.AopBean;
import ua.antonio.spring4sample.domain.AopBeanImpl;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public AopBean aopBean() {
        return new AopBeanImpl();
    }
}
