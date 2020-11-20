package pe.edu.upc.plates.model;


import lombok.Data;
import pe.edu.upc.plates.entity.Dish;
import pe.edu.upc.plates.entity.DishExtra;

import java.util.List;


@Data

public class OrderDetail{

    private Long id;
    private Order order;
    private Dish dish;
    private List<DishExtra> extras;
    private double subTotal;
}

