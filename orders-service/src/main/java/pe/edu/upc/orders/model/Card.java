package pe.edu.upc.orders.model;

import lombok.Data;

@Data

public class Card{
    private Long id;
    private String number;
    private Client client;
}
