package pe.edu.upc.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.management.entity.Restaurant;
import pe.edu.upc.management.service.RestaurantService;
import pe.edu.upc.management.util.Message;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id")Long id){
        Restaurant restaurantDB =  restaurantService.getRestaurantById(id);
        if(restaurantDB == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurantDB);
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<List<Restaurant>>listRestaurantsByManager(@PathVariable("id") Long id){
        List<Restaurant> cards = restaurantService.getRestaurants();
        if (cards.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cards);
    }

    @PostMapping
    public ResponseEntity<Restaurant> postRestaurant(@Valid @RequestBody Restaurant restaurant, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Restaurant restaurantDB = restaurantService.createRestaurant(restaurant);

        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") long id, @RequestBody Restaurant restaurant){
        Restaurant restaurantDB =  restaurantService.getRestaurantById(id);
        if(restaurantDB == null){
            return ResponseEntity.notFound().build();
        }
        restaurant.setId(id);
        restaurantDB = restaurantService.updateRestaurant(id, restaurant);

        return ResponseEntity.ok(restaurantDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Long id){
        Restaurant restaurantDB =  restaurantService.getRestaurantById(id);
        if(restaurantDB == null){
            return ResponseEntity.notFound().build();
        }

        return restaurantService.deleteRestaurant(id);
    }
}
