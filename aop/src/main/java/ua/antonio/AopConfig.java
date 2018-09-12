package ua.antonio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ua.antonio.bean.AopBean;
import ua.antonio.bean.AopBeanImpl;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public AopBean aopBean() {
        return new AopBeanImpl();
    }
}
