package pe.edu.upc.plates.model;


import lombok.Data;

@Data

public class Card {

    private Long id;
    private String number;
    private Client client;
}
