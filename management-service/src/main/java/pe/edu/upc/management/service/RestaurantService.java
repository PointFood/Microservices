package pe.edu.upc.management.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.management.entity.Restaurant;

import java.util.List;

public interface RestaurantService{
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);
    Restaurant updateRestaurant(Long id, Restaurant restaurant);
    ResponseEntity<?> deleteRestaurant(Long id);
    List<Restaurant> getRestaurants();
}
