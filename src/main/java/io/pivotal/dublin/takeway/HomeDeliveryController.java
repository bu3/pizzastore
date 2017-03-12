package io.pivotal.dublin.takeway;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HomeDeliveryController {

    private final OrderRepository orderRepository;

    public HomeDeliveryController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    public void saveOrder(@Valid @RequestBody Order order) {
        orderRepository.save(order);
    }

    @GetMapping("/orders")
    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

}
