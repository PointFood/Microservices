package pe.edu.upc.plates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.plates.model.OrderDetail;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="dish_extras")
public class DishExtra implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_detail_id")
    private Long OrderDetailId;
    @Transient
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "extra_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Extra extra;

    @Min(0)
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "subTotal", precision = 5, scale =  2, nullable = false)
    private double subTotal;
}
