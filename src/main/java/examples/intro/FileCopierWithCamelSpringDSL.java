package examples.intro;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileCopierWithCamelSpringDSL {
    public static void main(String[] args) throws Exception {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("classpath:app-context.xml");
        CamelContext camelContext = new SpringCamelContext(springContext);
        camelContext.start();
        Thread.sleep(1000);
        camelContext.close();
    }
}
