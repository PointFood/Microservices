package pe.edu.upc.plates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.plates.entity.Extra;

import java.util.List;

@Repository
public interface ExtraRepository extends JpaRepository<Extra, Long> {

    @Query("SELECT di FROM Dish di WHERE di.RestaurantId=?1")
    List<Extra> findExtrasByRestaurant(Long id);
}
