package ua.antonio.spring4sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.antonio.spring4sample.domain.User;
import ua.antonio.spring4sample.service.UserService;

public class Application {

    public static void main(String[] args) {
//        tryJavaConfig();
//        tryXmlConfig();
        tryLifecycleConfig();
    }

    private static void tryLifecycleConfig() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/lifacycle-config.xml");
        ((ClassPathXmlApplicationContext) context).close();
    }

    private static void tryJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        checkTheBean(context);
    }

    private static void tryXmlConfig() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/types-injection-config.xml");
        checkTheBean(context);
    }

    private static void checkTheBean(ApplicationContext context) {
        // Two ways to obtian beans
        UserService userService = (UserService) context.getBean("simpleUserService");
        UserService userService1 = context.getBean("simpleUserService", UserService.class);

        User user = new User();
        userService.save(user);
    }
}
