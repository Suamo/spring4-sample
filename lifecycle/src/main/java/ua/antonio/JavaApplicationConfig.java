package ua.antonio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Configuration
public class JavaApplicationConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public JavaConfigLifecycleBean lifecycleBean() {
        return new JavaConfigLifecycleBean();
    }

    @Bean
    public User defaultScopeBean() {
        return new User();
    }

    @Bean
    @Scope(SCOPE_SINGLETON)
    public User singletonScopeBean() {
        return new User();
    }

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public User prototypeScopeBean() {
        return new User();
    }
}
