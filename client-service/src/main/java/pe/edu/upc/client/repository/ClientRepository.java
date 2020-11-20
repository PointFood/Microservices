package pe.edu.upc.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.client.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.username=?1 and c.password=?2")
    Client findClientByUsernameAndPassword(String username, String password);

    @Query("SELECT c FROM Client c WHERE c.username=?1 and c.email=?2")
    Client findClientByUsernameAndEmail(String username, String email);

    Client findClientById(Long id);
}