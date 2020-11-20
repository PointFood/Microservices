package pe.edu.upc.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.client.entity.Client;
import pe.edu.upc.client.service.ClientService;
import pe.edu.upc.client.util.Message;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping
    public ResponseEntity<Client> postClient(@Valid @RequestBody Client client, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Client clientDB = clientService.createClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientDB);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")Long id){
        Client clientDB = clientService.getClientById(id);
        if(clientDB == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        Client clientDB = clientService.getClientById(id);
        if (clientDB == null) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        clientDB = clientService.updateClient(id, client);

        return ResponseEntity.ok(clientDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        Client clientDB = clientService.getClientById(id);
        if (clientDB == null) {
            return ResponseEntity.notFound().build();
        }

        return clientService.deleteClient(id);
    }

    @GetMapping("/login")
    public ResponseEntity<Client> login(@RequestBody Client client){
        Client clientDB = clientService.getClientByUsernameAndPassword(client.getUsername(), client.getPassword());
        if(clientDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDB);
    }

    @GetMapping("/recover")
    public ResponseEntity<Client> recoverAccount(@RequestBody Client client){
        Client clientDB = clientService.getClientByUsernameAndEmail(client.getUsername(), client.getEmail());
        if(clientDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDB);
    }

 
}
