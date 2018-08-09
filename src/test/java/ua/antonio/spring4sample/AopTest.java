package ua.antonio.spring4sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.domain.AopBean;
import ua.antonio.spring4sample.domain.AopBeanImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {
    private static ConfigurableApplicationContext CONTEXT = new AnnotationConfigApplicationContext(AopConfig.class);
    private static ConfigurableApplicationContext XML_CONTEXT = new ClassPathXmlApplicationContext("spring/aop-config.xml");


	@Test
	public void testTypesInjections() {
        AopBean bean = XML_CONTEXT.getBean("aopBeanImpl", AopBean.class);
        List<String> actions = bean.getActionsSequence();
        assertEquals(0, actions.size());

        bean.validateName();

        assertEquals(4, actions.size());
    }


}
