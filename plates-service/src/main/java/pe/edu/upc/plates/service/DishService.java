package pe.edu.upc.plates.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.plates.entity.Dish;

import java.util.List;

public interface DishService {

    Dish createDish(Dish dish);
    Dish getDishById(Long id);
    Dish updateDish(Long id, Dish dish);
    ResponseEntity<?> deleteDish(Long id);
    List<Dish> getDishesByRestaurant(Long id);
}
