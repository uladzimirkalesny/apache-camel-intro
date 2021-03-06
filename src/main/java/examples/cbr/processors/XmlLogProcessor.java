package examples.cbr.processors;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("xmlLogProcessor")
public class XmlLogProcessor implements LogProcessor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Перемещаем файл " + exchange.getIn().getHeader("CamelFileName") + " в папку xml");
    }
}
