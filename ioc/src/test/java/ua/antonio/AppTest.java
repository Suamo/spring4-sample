package ua.antonio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.confg.ScanningConfig;
import ua.antonio.confg.SimpleConfig;
import ua.antonio.domain.SimpleBean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
public class AppTest {

    @Test
    public void java_AutowiredContext() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ScanningConfig.class);
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

    @Test
    public void java_SimpleContext() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfig.class);
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

    @Test
    public void xml_AutowiredContext() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("scanning-context.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

    @Test
    public void xml_SimpleContext() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("simple-context.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNull(bean.getChild());
    }

}
