package pe.edu.upc.plates.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.plates.entity.Dish;
import pe.edu.upc.plates.exception.ResourceNotFoundException;
import pe.edu.upc.plates.repository.DishRepository;
import pe.edu.upc.plates.service.DishService;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Transactional
    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Transactional(readOnly = true)
    @Override
    public Dish getDishById(Long id) {
        return dishRepository.findDishById(id);
    }

    @Transactional
    @Override
    public Dish updateDish(Long id, Dish dish) {
        Dish dishDB = dishRepository.getOne(id);

        dishDB.setName(dish.getName());
        dishDB.setDescription(dish.getDescription());
        dishDB.setPrice(dish.getPrice());

        return dishRepository.save(dishDB);
    }

    @Transactional
    @Override
    public ResponseEntity<?> deleteDish(Long id) {
        Dish dishDB = dishRepository.getOne(id);
        if(dishDB == null){
            throw new ResourceNotFoundException("There is no dish with Id " + id);
        }
        dishRepository.delete(dishDB);

        return ResponseEntity.ok().build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dish> getDishesByRestaurant(Long id) {
        return dishRepository.findDishesByRestaurant(id);
    }
}
