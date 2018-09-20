package ua.antonio.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.antonio.domain.SimpleBean;
import ua.antonio.domain.SimpleBean2;

@Configuration
public class SimpleConfig {

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

    @Bean
    public SimpleBean2 simpleBean2() {
        return new SimpleBean2();
    }

}
