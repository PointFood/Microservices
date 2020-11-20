package pe.edu.upc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.management.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    Restaurant findRestaurantsById(Long id);
}
