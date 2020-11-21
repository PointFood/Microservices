package pe.edu.upc.plates.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.plates.model.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="dishes")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Min(0)
    @Column(name = "price", precision = 5, scale =  2, nullable = false)
    private double price;

    @Column(name = "restaurant_id")
    private Long RestaurantId;
    @Transient
    private Restaurant restaurant;
}
