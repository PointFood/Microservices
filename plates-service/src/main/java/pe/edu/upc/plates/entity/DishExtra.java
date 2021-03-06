package pe.edu.upc.plates.entity;

import lombok.Data;
import pe.edu.upc.plates.model.OrderDetail;

import java.io.Serializable;

@Data

public class DishExtra implements Serializable {

    private Long id;
    private OrderDetail orderDetail;
    private Extra extra;
    private int quantity;
    private double subTotal;
}
