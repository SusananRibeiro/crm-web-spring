package com.crm.web.rest;
import com.crm.web.dtos.ClientInputDTO;
import com.crm.web.models.Client;
import com.crm.web.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
     private ClientService clientService; // variavel para armazenar o ClientService

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }
    // Busca de cliente por ID
    @GetMapping({"id"}) // "({"id"})" vai representar
    private ResponseEntity<Client> getClientById(@PathVariable("id") int idClient) {
        return ResponseEntity.ok(clientService.getClientById(idClient));
    }

    @GetMapping // Método HTTP GET -> consultar
    public ResponseEntity<Iterable<Client>> getClients() {
        return ResponseEntity.ok(clientService.getClients());

    }
    @PostMapping // Método HTTP POST -> inserir
    public ResponseEntity addClient(@Valid @RequestBody ClientInputDTO client) {
        this.clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
