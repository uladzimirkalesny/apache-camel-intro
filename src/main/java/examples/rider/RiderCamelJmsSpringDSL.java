package examples.rider;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RiderCamelJmsSpringDSL {
    public static void main(String[] args) throws Exception {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("classpath:rider-app-context.xml");
        CamelContext camelContext = new SpringCamelContext(springContext);
        camelContext.start();
        Thread.sleep(1000);
        camelContext.close();
    }
}
