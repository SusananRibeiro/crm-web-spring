package com.crm.web.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClientService {
    private List<String> clients;
    public ClientService() {
        this.clients = new ArrayList<>(); // inicializando a lista no construtor

    }
    // Método que vai retornar todos os clientes
    public List<String> getClients() {
        return this.clients;
    }

    // Método para adicionar cliente
    public void addClient(String client) {
        this.clients.add(client);
    }

}
