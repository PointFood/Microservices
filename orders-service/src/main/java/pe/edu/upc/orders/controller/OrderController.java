package pe.edu.upc.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.orders.Entity.Order;
import pe.edu.upc.orders.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> fetchAll() {
        try {
            List<Order> orders = orderService.findAll();
            return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Order> optionalOrder = orderService.findById(id);
            if(optionalOrder.isPresent()) {
                return new ResponseEntity<Order>(optionalOrder.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
