package ua.antonio.spring4sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.antonio.spring4sample.domain.User;
import ua.antonio.spring4sample.repository.JdbcUserRepo;
import ua.antonio.spring4sample.repository.UserRepo;
import ua.antonio.spring4sample.service.SimpleUserService;
import ua.antonio.spring4sample.service.UserService;

import javax.sql.DataSource;

public class JavaConfiguredApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = (UserService) context.getBean("simpleUserService");

        User user = new User();
        userService.save(user);
    }
}

@Configuration
class ApplicationConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/my_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    @Bean
    public UserService simpleUserService() {
        return new SimpleUserService(userRepo());
    }

    @Bean
    public UserRepo userRepo() {
        return new JdbcUserRepo(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        ds.setDriverClassName(DRIVER);
        return ds;
    }
}
