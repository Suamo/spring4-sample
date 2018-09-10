package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true) // enables REST methods interception restrictions
@ComponentScans({
		@ComponentScan("ua.antonio.spring4sample.controllers"),
		@ComponentScan("ua.antonio.spring4sample.config.security")
})
public class SecuredMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredMvcApplication.class);
	}

}
