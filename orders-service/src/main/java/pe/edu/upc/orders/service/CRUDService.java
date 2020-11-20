package pe.edu.upc.orders.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CRUDService<T, ID> {
    T save(T entity) throws Exception;
    List<T> findAll() throws Exception;
    Optional<T> findById(ID id) throws Exception;
    T update(T entity) throws Exception;
    void deleteById( ID id ) throws Exception;
}
