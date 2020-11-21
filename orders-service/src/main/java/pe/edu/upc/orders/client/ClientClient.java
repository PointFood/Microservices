package pe.edu.upc.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.orders.model.Client;

@FeignClient(name = "client-service")
@RequestMapping(value = "clients")

public interface ClientClient {

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")Long id);
}
