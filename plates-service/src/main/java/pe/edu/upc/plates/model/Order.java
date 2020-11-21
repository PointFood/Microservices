package pe.edu.upc.plates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data

public class Order implements Serializable {

    private Long id;
    private Client client;
    private Date registeredAt;
    private Restaurant restaurant;
    private boolean delivery;
    private String address;
    private double total;
    private String status;
}
