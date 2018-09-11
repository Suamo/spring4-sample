package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/**
 * Based on tutorial: https://spring.io/guides/gs/producing-web-service/
 */
@SpringBootApplication(
        scanBasePackages = {
                "ua.antonio.spring4sample.config.ws",
                "ua.antonio.spring4sample.repository.ws",
                "ua.antonio.spring4sample.service"},
        exclude = {SecurityAutoConfiguration.class}
)
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class);
    }

}
