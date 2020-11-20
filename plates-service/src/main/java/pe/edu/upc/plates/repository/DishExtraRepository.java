package pe.edu.upc.plates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.plates.entity.DishExtra;

@Repository
public interface DishExtraRepository extends JpaRepository<DishExtra, Long> {
}
