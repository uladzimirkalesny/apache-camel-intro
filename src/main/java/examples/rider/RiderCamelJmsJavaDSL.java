package examples.rider;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
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
            public void configure() throws Exception {
                from("ftp://rider.com/orders?username=rider&password=secret").to("jms:incomingOrders");
            }
        });

        camelContext.start();
        Thread.sleep(10000);

        camelContext.stop();
    }
}
