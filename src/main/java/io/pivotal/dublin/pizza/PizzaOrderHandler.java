package io.pivotal.dublin.pizza;

import org.axonframework.commandhandling.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class PizzaOrderHandler {

    private static final Logger log = LoggerFactory.getLogger(PizzaOrder.class);

    @CommandHandler
    public void handle(PreparePizza preparePizza) {
        log.info("New Order arrived! {}", preparePizza.getPizzaOrder().getPizza()   );
    }
}
