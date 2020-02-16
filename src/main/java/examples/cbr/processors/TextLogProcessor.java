package examples.cbr.processors;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("textLogProcessor")
public class TextLogProcessor implements LogProcessor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Перемещаем файл " + exchange.getIn().getHeader("CamelFileName") + " в папку text");
    }
}
