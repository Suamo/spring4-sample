package ua.antonio.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.antonio.domain.SimpleBean;

@Configuration
public class SimpleConfig {

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

}
