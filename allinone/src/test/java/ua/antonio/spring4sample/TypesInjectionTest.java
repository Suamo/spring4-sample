package ua.antonio.spring4sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.domain.types.AllTypes;
import ua.antonio.spring4sample.domain.types.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypesInjectionTest {
    private static ConfigurableApplicationContext TYPES_CONTEXT = new ClassPathXmlApplicationContext("spring/types-injection-config.xml");


	@Test
	public void testTypesInjections() {
        AllTypes bean = TYPES_CONTEXT.getBean("allTypesBean", AllTypes.class);

        String stringValue = bean.getStringValue();
        assertEquals("some text", stringValue);

        boolean booleanValue = bean.getBooleanValue();
        assertTrue(booleanValue);

        byte byteValue = bean.getByteValue();
        assertEquals((byte)1, byteValue);

        short shortValue = bean.getShortValue();
        assertEquals((short)2, shortValue);
        int intValue = bean.getIntValue();
        assertEquals(3, intValue);
        long longValue = bean.getLongValue();
        assertEquals((long)4, longValue);

        Integer integer = bean.getInteger();
        assertEquals(new Integer(11), integer);

        List list = bean.getList();
        assertEquals("text 1", list.get(0));
        assertEquals("text 2", list.get(1));

        Set set = bean.getSet();
        assertTrue(set.contains("text 11"));
        assertTrue(set.contains("text 21"));

        Map map = bean.getMap();
        assertEquals("Value1", map.get("key1"));
        assertEquals("Value2", map.get("key2"));

        Properties prop1 = bean.getPropertiesFromInnerBlock();
        assertEquals("Value21", prop1.getProperty("key1"));
        assertEquals("Value22", prop1.getProperty("key2"));
        Properties prop2 = bean.getPropertiesFromFile();
        assertEquals("value12", prop2.getProperty("key12"));
        assertEquals("value13", prop2.getProperty("key13"));

        Date createdWithStandardDateConverter = bean.getCreatedWithStandardDateConverter();
        assertEquals("2018/12/10", new SimpleDateFormat("yyyy/MM/dd").format(createdWithStandardDateConverter));

        LocalDate createdWithCustomDateConverter = bean.getCreatedWithCustomDateConverter();
        assertEquals("2018-10-12", createdWithCustomDateConverter.format(DateTimeFormatter.ISO_DATE));

        Object nullObject = bean.getNullObject();
        assertNull(nullObject);

        Thread createdWithFactoryMethod = bean.getCreatedWithFactoryMethod();
        assertNotNull(createdWithFactoryMethod);
        Thread createdWithFactoryBean = bean.getCreatedWithFactoryBean();
        assertNotNull(createdWithFactoryBean);

        User parentUser = bean.getParentUser();
        assertEquals(15, parentUser.getAge());
        assertEquals("UserParent", parentUser.getName());
        User childUser = bean.getChildUserWithInheritedAge();
        assertEquals(15, childUser.getAge());
        assertEquals("UserChild", childUser.getName());
    }


}
