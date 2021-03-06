package io.pivotal.dublin.pizza;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PizzaOrder {

    private String pizza;
    private String city;
    private Double amount;

}
