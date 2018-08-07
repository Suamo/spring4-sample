package ua.antonio.spring4sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
@ImportResource("classpath:spring/types-injection-config.xml") // applying XML configuration in Java
public class ApplicationConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/my_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    @Value("${key12}")
    private String propertyValue;

}
