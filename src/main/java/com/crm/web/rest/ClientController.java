package com.crm.web.rest;

import com.crm.web.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/client")
public class ClientController {
     private ClientService clientService; // variavel para armazenar o ClientService

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public List<String> getClients() {
        return this.clientService.getClients();
    }
    @PostMapping
    public void addClient(@RequestBody String client) {
        this.clientService.addClient(client);
    }
}
