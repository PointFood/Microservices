package pe.edu.upc.client.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.client.entity.Client;

public interface ClientService {

    Client createClient(Client client);
    Client getClientById(Long id);
    Client updateClient(Long id, Client client);
    ResponseEntity<?> deleteClient(Long id);
    Client getClientByUsernameAndPassword(String username, String password);
    Client getClientByUsernameAndEmail(String username, String email);
}
