package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import ua.antonio.spring4sample.aop.rest.RestExceptionProcessor;
import ua.antonio.spring4sample.controllers.rest.SimpleRestController;

@SpringBootApplication(
        scanBasePackageClasses = {
                SimpleRestController.class,
                RestExceptionProcessor.class
        },
        exclude = {
                SecurityAutoConfiguration.class
        }
)
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class);
    }

}
