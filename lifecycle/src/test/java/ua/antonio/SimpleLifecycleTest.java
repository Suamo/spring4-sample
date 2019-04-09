package ua.antonio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JavaApplicationConfig.class)
public class SimpleLifecycleTest {

    @Autowired
    private JavaConfigLifecycleBean lifecycleBean;

    @Autowired
    private ConfigurableApplicationContext applicationContext;


	@Test
	public void testJavaConfigLifecycle() {
        applicationContext.close();
        List<String> sequence = lifecycleBean.getInitSequence();
        assertEquals(sequence.get(0), "'before initialization' BeanPostProcessor (@PostConstruct)");
        assertEquals(sequence.get(1), "InitializingBean.afterPropertiesSet");
        assertEquals(sequence.get(2), "initMethod attribute");

        assertEquals(sequence.get(3), "'before destroy' BeanPostProcessor (@PreDestroy)");
        assertEquals(sequence.get(4), "DisposableBean.destroy");
        assertEquals(sequence.get(5), "destroyMethod attribute");
    }

}
