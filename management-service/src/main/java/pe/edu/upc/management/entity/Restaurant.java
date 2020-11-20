package pe.edu.upc.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="restaurants")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 9, nullable = false)
    private String phone;

    @JoinColumn(name="manager_id")
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Manager manager;
}
