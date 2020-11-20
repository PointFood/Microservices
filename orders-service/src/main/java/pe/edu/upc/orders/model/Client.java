package pe.edu.upc.orders.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Client {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Date signedUpAt;
    private String username;
    private String password;
    private List<Card> cards;
}
