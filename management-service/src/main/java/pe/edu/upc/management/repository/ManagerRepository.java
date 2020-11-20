package pe.edu.upc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.management.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query("SELECT ro FROM Manager ro WHERE ro.username=?1 and ro.password=?2")
    Manager findRestaurantOwnerByUsernameAndPassword(String username, String password);

    @Query("SELECT ro FROM Manager ro WHERE ro.username=?1 and ro.email=?2")
    Manager findRestaurantOwnerByUsernameAndEmail(String username, String email);

    Manager findRestaurantOwnerById(Long id);
}
