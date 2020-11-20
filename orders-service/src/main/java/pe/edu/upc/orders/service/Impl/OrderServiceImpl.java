package pe.edu.upc.orders.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.orders.Entity.Order;
import pe.edu.upc.orders.repository.OrderRepository;
import pe.edu.upc.orders.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order save(Order entity) throws Exception {
        return orderRepository.save(entity);
    }

    @Override
    public List<Order> findAll() throws Exception {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long aLong) throws Exception {
        return orderRepository.findById(aLong);
    }

    @Override
    public Order update(Order entity) throws Exception {
        return orderRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        orderRepository.deleteById(aLong);
    }
}
