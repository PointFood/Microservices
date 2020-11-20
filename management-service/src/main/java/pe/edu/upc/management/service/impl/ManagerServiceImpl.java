package pe.edu.upc.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.management.entity.Manager;
import pe.edu.upc.management.exception.ResourceNotFoundException;
import pe.edu.upc.management.repository.ManagerRepository;
import pe.edu.upc.management.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Transactional
    @Override
    public Manager createRestaurantOwner(Manager manager) {
        return managerRepository.save(manager);
    }

    @Transactional(readOnly = true)
    @Override
    public Manager getRestaurantOwnerById(Long id) {
        return managerRepository.findRestaurantOwnerById(id);
    }

    @Transactional
    @Override
    public Manager updateRestaurantOwner(Long id, Manager manager) {
        Manager managerDB = managerRepository.getOne(id);
        if(managerDB == null){
            throw new ResourceNotFoundException("There is no restaurant with Id " + id );
        }
        managerDB.setName(manager.getName());
        managerDB.setPhone(manager.getPhone());
        managerDB.setEmail(manager.getEmail());
        managerDB.setUsername(manager.getUsername());
        managerDB.setPassword(manager.getPassword());

        return managerRepository.save(managerDB);
    }

    @Transactional
    @Override
    public ResponseEntity<?> deleteRestaurantOwner(Long id) {
        Manager managerDB = managerRepository.getOne(id);
        if(managerDB == null){
            throw new ResourceNotFoundException("There is no restaurant with Id " + id );
        }
        managerRepository.delete(managerDB);

        return ResponseEntity.ok().build();
    }

    @Transactional(readOnly = true)
    @Override
    public Manager getRestaurantOwnerByUsernameAndPassword(String username, String password) {
        return managerRepository.findRestaurantOwnerByUsernameAndPassword(username, password);
    }

    @Transactional(readOnly = true)
    @Override
    public Manager getRestaurantOwnerByUsernameAndEmail(String username, String email) {
        return managerRepository.findRestaurantOwnerByUsernameAndEmail(username, email);
    }
}
