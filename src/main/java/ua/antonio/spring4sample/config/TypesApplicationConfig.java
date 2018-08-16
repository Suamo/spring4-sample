package ua.antonio.spring4sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
@ImportResource("classpath:spring/types-injection-config.xml") // applying XML configuration in Java
public class TypesApplicationConfig {

    @Value("${key12}")
    private String propertyValue;

}
