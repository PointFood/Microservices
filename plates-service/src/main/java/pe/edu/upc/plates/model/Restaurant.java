package pe.edu.upc.plates.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pe.edu.upc.plates.entity.Dish;
import pe.edu.upc.plates.entity.Extra;
import java.util.List;

@Data
public class Restaurant{
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String managerId;
    private List<Dish> dishes;
    private List<Extra> extras;
}
