package pe.edu.upc.orders.model;

import lombok.Data;

@Data
public class Dish {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Restaurant restaurant;
}
