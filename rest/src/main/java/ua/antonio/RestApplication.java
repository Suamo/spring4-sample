package ua.antonio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import ua.antonio.aop.RestExceptionProcessor;

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
