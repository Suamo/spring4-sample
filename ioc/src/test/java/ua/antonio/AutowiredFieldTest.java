package ua.antonio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.confg.ScanningConfig;
import ua.antonio.domain.SimpleBean;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ScanningConfig.class })
public class AutowiredFieldTest {

    @Autowired
    SimpleBean bean;

    @Test
    public void java_AutowiredContext() {
        assertNotNull(bean);
        assertNotNull(bean.getChild());
    }

}
