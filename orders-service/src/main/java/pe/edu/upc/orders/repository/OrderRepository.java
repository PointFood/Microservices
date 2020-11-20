package pe.edu.upc.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.orders.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
