package ua.antonio.spring4sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypesInjectionTest {
    private static ConfigurableApplicationContext TYPES_CONTEXT = new ClassPathXmlApplicationContext("spring/types-injection-config.xml");


	@Test
	public void testTypesInjections() {

    }


}
