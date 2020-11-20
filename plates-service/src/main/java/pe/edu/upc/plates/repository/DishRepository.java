package pe.edu.upc.plates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.plates.entity.Dish;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query("SELECT di FROM Dish di WHERE di.RestaurantId=?1")
    List<Dish> findDishesByRestaurant(Long id);

    Dish findDishById(Long id);
}
