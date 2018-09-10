package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
		@ComponentScan("ua.antonio.spring4sample.controllers"),
		@ComponentScan("ua.antonio.spring4sample.config.security")
})
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class);
	}

}
