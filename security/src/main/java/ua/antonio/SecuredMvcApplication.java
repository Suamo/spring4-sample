package ua.antonio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true) // enables REST methods interception restrictions
public class SecuredMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredMvcApplication.class);
	}

}
