package ua.antonio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.antonio.aop.RestExceptionProcessor;

@SpringBootApplication(
        scanBasePackageClasses = {
                SimpleRestController.class,
                RestExceptionProcessor.class
        }
)
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class);
    }

}
