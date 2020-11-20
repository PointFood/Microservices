package pe.edu.upc.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.management.entity.Restaurant;
import pe.edu.upc.management.exception.ResourceNotFoundException;
import pe.edu.upc.management.repository.RestaurantRepository;
import pe.edu.upc.management.service.RestaurantService;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional(readOnly = true)
    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findRestaurantsById(id);
    }

    @Transactional
    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant restaurantDB= restaurantRepository.getOne(id);
        if(restaurantDB==null){
            throw new ResourceNotFoundException("There is no restaurant with Id " + id);
        }
        restaurantDB.setName(restaurant.getName());
        restaurantDB.setAddress(restaurant.getAddress());
        restaurantDB.setPhone(restaurant.getPhone());

        return restaurantRepository.save(restaurantDB);
    }

    @Transactional
    @Override
    public ResponseEntity<?> deleteRestaurant(Long id) {
        Restaurant restaurantDB= restaurantRepository.getOne(id);
        if(restaurantDB==null){
            throw new ResourceNotFoundException("There is no restaurant with Id " + id);
        }
        restaurantRepository.delete(restaurantDB);

        return ResponseEntity.ok().build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}
