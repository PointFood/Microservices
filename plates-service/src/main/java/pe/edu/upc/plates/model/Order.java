package pe.edu.upc.plates.model;

import lombok.Data;
import java.util.Date;

@Data
public class Order {
    private Long id;
    private Client client;
    private Date registeredAt;
    private Restaurant restaurant;
    private boolean delivery;
    private String address;
    private double total;
    private Status status;
}
