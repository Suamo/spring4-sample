package ua.antonio.spring4sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import ua.antonio.spring4sample.domain.ws.GetCountryRequest;
import ua.antonio.spring4sample.domain.ws.GetCountryResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = WsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WsTest {

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @LocalServerPort
    private int port = 0;
    private String uri;

    @Before
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCountryRequest.class));
        marshaller.afterPropertiesSet();
        uri = "http://localhost:" + port + "/ws";
    }

    @Test
    public void testSendAndReceive() {
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetCountryRequest request = new GetCountryRequest();
        request.setName("Spain");

        GetCountryResponse actual = (GetCountryResponse)ws.marshalSendAndReceive(uri, request);
        Assert.assertEquals("Madrid", actual.getCountry().getCapital());
    }
}