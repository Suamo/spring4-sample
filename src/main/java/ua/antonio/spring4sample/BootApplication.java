package ua.antonio.spring4sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SpringBootApplication
public class BootApplication implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		registration.setInitParameter("contextConfigLocation", "ua.antonio.spring4sample.config.web.WebConfig");
		registration.setInitParameter("contextClass", "o.s.w.c.s.AnnotationConfigWebApplicationContext");
	}

}
