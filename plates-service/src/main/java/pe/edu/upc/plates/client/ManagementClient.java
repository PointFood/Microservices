package pe.edu.upc.plates.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.plates.model.Manager;
import pe.edu.upc.plates.model.Restaurant;

@FeignClient(name = "management-service")
@RequestMapping(value = "managements")

public interface ManagementClient {

    @GetMapping(value = "/manager/{id}")
    public ResponseEntity<Manager> getRestaurantOwner(@PathVariable("id")Long id);

    @GetMapping(value = "/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id")Long id);
}
