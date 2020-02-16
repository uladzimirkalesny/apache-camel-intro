package examples.rider;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class RiderCamelJmsJavaDSL {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("ftp://rider.com/orders?username=rider&password=secret")
                        .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) {
                                System.out.println("We just downloaded: " + exchange.getIn()
                                                                                    .getHeader("CamelFileName"));
                            }
                        }).to("jms:incomingOrders");
            }
        });

        camelContext.start();
        Thread.sleep(10000);

        camelContext.stop();
    }
}
