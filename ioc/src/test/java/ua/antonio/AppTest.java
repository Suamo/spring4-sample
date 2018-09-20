package ua.antonio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.antonio.confg.ScanningConfig;
import ua.antonio.confg.SimpleConfig;
import ua.antonio.domain.SimpleBean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AppTest {

    @Test
    public void java_ScanningContext() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ScanningConfig.class);
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

    @Test
    public void xml_ScanningContext() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("scanning-context.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

    /**
     * AnnotationConfigApplicationContext checks Autowired annotations.
     * So if beans are declared in configuration they will be injected by Autowired annotation.
     * @see Autowired
     */
    @Test
    public void java_SimpleContext() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfig.class);
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

    /**
     * ClassPathXmlApplicationContext is not checking Autowired annotations.
     * So if beans are declared in configuration they will NOT be injected by Autowired annotation.
     */
    @Test
    public void xml_SimpleContext() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("simple-context.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);

        assertNotNull(bean);
        assertNull(bean.getChild());
    }

}
