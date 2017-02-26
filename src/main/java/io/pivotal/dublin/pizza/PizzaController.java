package io.pivotal.dublin.pizza;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/pizzas")
    public void saveOrder(@RequestBody PizzaOrder pizzaOrder) {
        PreparePizza preparePizza = new PreparePizza();
        preparePizza.setPizzaOrder(pizzaOrder);

        commandGateway.send(preparePizza);
    }
}
