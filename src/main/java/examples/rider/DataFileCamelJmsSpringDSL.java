package examples.rider;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataFileCamelJmsSpringDSL {
    public static void main(String[] args) throws Exception {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("classpath:data-file-app-context.xml");
        CamelContext camelContext = new SpringCamelContext(springContext);
        camelContext.start();
        Thread.sleep(10000);
        camelContext.close();
    }
}
