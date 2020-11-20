package pe.edu.upc.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Manager manager;
    private List<Dish> dishes;
    private List<Extra> extras;
}
