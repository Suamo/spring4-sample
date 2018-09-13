package ua.antonio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringLifecycleTest {
    private static ConfigurableApplicationContext XML_CONTEXT = new ClassPathXmlApplicationContext("lifacycle-config.xml");
    private static ConfigurableApplicationContext JAVA_CONTEXT = new AnnotationConfigApplicationContext(JavaApplicationConfig.class);


	@Test
	public void testXmlConfigLifecycle() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("lifacycle-config.xml");
        XmlConfigLifecycleBean bean = context.getBean("lifecycleBean", XmlConfigLifecycleBean.class);
        context.close();

        List<String> sequence = bean.getInitSequence();
        assertEquals(sequence.get(0), "constructor");
        assertEquals(sequence.get(1), "setter");

        assertEquals(sequence.get(2), "InitializingBean.afterPropertiesSet");
        assertEquals(sequence.get(3), "init-method");

        assertEquals(sequence.get(4), "DisposableBean.destroy");
        assertEquals(sequence.get(5), "destroy-method");
    }

	@Test
	public void testJavaConfigLifecycle() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(JavaApplicationConfig.class);
        JavaConfigLifecycleBean bean = context.getBean("lifecycleBean", JavaConfigLifecycleBean.class);
        context.close();

        List<String> sequence = bean.getInitSequence();
        assertEquals(sequence.get(0), "'before initialization' BeanPostProcessor (@PostConstruct)");
        assertEquals(sequence.get(1), "InitializingBean.afterPropertiesSet");
        assertEquals(sequence.get(2), "initMethod attribute");

        assertEquals(sequence.get(3), "'before destroy' BeanPostProcessor (@PreDestroy)");
        assertEquals(sequence.get(4), "DisposableBean.destroy");
        assertEquals(sequence.get(5), "destroyMethod attribute");

    }

	@Test
	public void testDefaultScopeBeans_XmlConfig() {
        twiceTakenBeanIsTheSame(XML_CONTEXT, "defaultScopeBean");
        twiceTakenBeanIsTheSame(XML_CONTEXT, "singletonScopeBean");
        twiceTakenBeanIsNotTheSame(XML_CONTEXT, "prototypeScopeBean");

        twiceTakenBeanIsTheSame(JAVA_CONTEXT, "defaultScopeBean");
        twiceTakenBeanIsTheSame(JAVA_CONTEXT, "singletonScopeBean");
        twiceTakenBeanIsNotTheSame(JAVA_CONTEXT, "prototypeScopeBean");
	}

    private void twiceTakenBeanIsTheSame(ConfigurableApplicationContext context, String beanName) {
        Object bean1 = context.getBean(beanName);
        Object bean2 = context.getBean(beanName);
        assertSame(bean1, bean2);
    }

    private void twiceTakenBeanIsNotTheSame(ConfigurableApplicationContext context, String beanName) {
        Object bean1 = context.getBean(beanName);
        Object bean2 = context.getBean(beanName);
        assertNotSame(bean1, bean2);
    }

}
