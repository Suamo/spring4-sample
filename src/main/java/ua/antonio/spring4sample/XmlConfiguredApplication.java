package ua.antonio.spring4sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.antonio.spring4sample.domain.User;
import ua.antonio.spring4sample.service.UserService;

public class XmlConfiguredApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
        UserService userService = (UserService) context.getBean("simpleUserService");

        User user = new User();
        userService.save(user);
    }
}
