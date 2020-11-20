package pe.edu.upc.orders.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.orders.model.Dish;
import pe.edu.upc.orders.model.Extra;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="order_details")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Order order;

    @Column(name = "dish_id")
    private Long dishId;
    @Transient
    private Dish dish;

    @Column(name = "extra_id")
    private Long extraId;
    @Transient
    private Extra extras;

    @Column(name = "total", precision = 6, scale =  2, nullable = false)
    private double subTotal;
}
