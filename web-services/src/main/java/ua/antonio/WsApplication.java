package ua.antonio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/**
 * Based on tutorial: https://spring.io/guides/gs/producing-web-service/
 */
@SpringBootApplication(
        exclude = {SecurityAutoConfiguration.class}
)
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class);
    }

}
