package examples.intro;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopierWithCamelJavaDSL {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }
}
