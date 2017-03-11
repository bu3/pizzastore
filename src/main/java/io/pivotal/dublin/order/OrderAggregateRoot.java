package io.pivotal.dublin.order;

import io.pivotal.dublin.pizza.PreparePizza;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AggregateRoot
public class OrderAggregateRoot {

    private static final Logger LOG = LoggerFactory.getLogger(OrderAggregateRoot.class);

    @AggregateIdentifier
    private Long id;

    @Autowired
    private OrderRepository orderRepository;

    protected OrderAggregateRoot() {
    }

    @CommandHandler
    public void createOrder(PreparePizza preparePizza) {
        LOG.info("Order stored");
        Order order = new Order();
        order.setPizza(preparePizza.getPizzaOrder().getPizza());
        Order storedOrder = orderRepository.save(order);
        this.id = storedOrder.getId();
        AggregateLifecycle.apply(new OrderCreatedEvent(storedOrder.getId()));
    }

    @EventSourcingHandler
    private void handleMyAggregateCreatedEvent(OrderCreatedEvent event) {
        LOG.info("Order created");
    }

}
