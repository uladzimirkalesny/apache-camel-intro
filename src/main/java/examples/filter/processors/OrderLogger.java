package examples.filter.processors;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("orderLogger")
public class OrderLogger implements LogProcessor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Received XML order: " + exchange.getIn().getHeader("CamelFileName"));
    }
}
