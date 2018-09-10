package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Based on tutorial: https://spring.io/guides/gs/producing-web-service/
 */
@SpringBootApplication
@ComponentScans({
        @ComponentScan("ua.antonio.spring4sample.config.ws"),
        @ComponentScan("ua.antonio.spring4sample.repository.ws")
})
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class);
    }

}
