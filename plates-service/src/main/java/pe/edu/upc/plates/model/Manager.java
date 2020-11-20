package pe.edu.upc.plates.model;

import lombok.Data;

import java.util.List;

@Data
public class Manager {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;
    private List<Restaurant> restaurants;
}
