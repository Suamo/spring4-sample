package ua.antonio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.bean.AopBean;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class AopTest {

	@Test
	public void testTypesInjections() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop-config.xml");
        AopBean bean = ctx.getBean(AopBean.class);

        List<String> actions = bean.getActionsSequence();
        assertEquals(0, actions.size());

        bean.validateName();

        assertEquals("Around Before", actions.get(0));
        assertEquals("Before", actions.get(1));
        assertEquals("Target method call", actions.get(2));
        assertEquals("Around After", actions.get(3));
        assertEquals("After", actions.get(4));
        assertEquals("After Returning", actions.get(5)); // called even for void return type
    }

	@Test
	public void testExceptionsInAdvices() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop-config.xml");
        AopBean bean = ctx.getBean(AopBean.class);
        bean.callMethodWithException();

        List<String> actions = bean.getActionsSequence();
        assertEquals("Around Before", actions.get(0));
        assertEquals("Before", actions.get(1));
        assertEquals("Exception method call", actions.get(2));
        assertEquals("Around After (Exception caught)", actions.get(3));
        // if an exception is caught by Aroud advice than AfterThrowing is ignored
        assertEquals("After", actions.get(4)); // called even if exception is thrown
        assertEquals("After Returning", actions.get(5));
    }

	@Test
	public void testPointcutExpression() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop-pointcuts-config.xml");
        AopBean bean = ctx.getBean(AopBean.class);
        bean.checkPointcut(1, 2L, new Date());

        List<String> actions = bean.getActionsSequence();
        assertTrue(actions.contains("executionByFullReferencePointcut"));

        assertTrue(actions.contains("executionByAllArgumentsPointcut"));
        assertTrue(actions.contains("executionByFirstArgumentPointcut"));

        assertTrue(actions.contains("executionByMethodNamePointcut"));

        assertTrue(actions.contains("withinPointcut"));
        assertTrue(actions.contains("targetPointcut"));
        assertTrue(actions.contains("thisPointcut"));

        assertTrue(actions.contains("targetAnnotatedPointcut"));
        assertTrue(actions.contains("annotatedPointcut"));

        assertTrue(actions.contains("andPointcut"));
        assertTrue(actions.contains("orPointcut"));
        assertTrue(actions.contains("notPointcut"));
    }

}
