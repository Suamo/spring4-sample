package ua.antonio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.bean.AopBean;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {
    private static ConfigurableApplicationContext XML_CONTEXT = new ClassPathXmlApplicationContext("spring/aop-config.xml");


	@Test
	public void testTypesInjections() {
        AopBean bean = XML_CONTEXT.getBean("aopBeanImpl", AopBean.class);
        List<String> actions = bean.getActionsSequence();
        assertEquals(0, actions.size());

        bean.validateName();

        assertEquals("Around Before", actions.get(0));
        assertEquals("Before", actions.get(1));
        assertEquals("Target method call", actions.get(2));
        assertEquals("Around After", actions.get(3));
        assertEquals("After", actions.get(4));
    }

}
