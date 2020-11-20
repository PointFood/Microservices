package pe.edu.upc.management.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.management.entity.Manager;

public interface ManagerService {

    Manager createRestaurantOwner(Manager manager);
    Manager getRestaurantOwnerById(Long id);
    Manager updateRestaurantOwner(Long id, Manager manager);
    ResponseEntity<?> deleteRestaurantOwner(Long id);
    Manager getRestaurantOwnerByUsernameAndPassword(String username, String password);
    Manager getRestaurantOwnerByUsernameAndEmail(String username, String email);
}
