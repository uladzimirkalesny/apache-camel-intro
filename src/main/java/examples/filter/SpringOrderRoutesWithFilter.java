package examples.filter;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringOrderRoutesWithFilter {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:filter-app-context.xml");

        CamelContext camelContext = new SpringCamelContext(applicationContext);

        camelContext.start();
        Thread.sleep(10000);

        camelContext.stop();
        camelContext.close();
    }
}
