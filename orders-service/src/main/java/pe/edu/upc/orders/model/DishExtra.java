package pe.edu.upc.orders.model;

import lombok.Data;

import pe.edu.upc.orders.Entity.OrderDetail;

@Data

public class DishExtra{

    private Long id;
    private OrderDetail orderDetail;
    private Extra extra;
    private int quantity;
    private double subTotal;
}
