package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(
		scanBasePackages = {"ua.antonio.spring4sample.controllers", "ua.antonio.spring4sample.config.security"}
)
@EnableGlobalMethodSecurity(jsr250Enabled = true) // enables REST methods interception restrictions
public class SecuredMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredMvcApplication.class);
	}

}
