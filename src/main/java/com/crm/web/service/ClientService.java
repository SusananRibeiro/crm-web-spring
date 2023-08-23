package com.crm.web.service;
import com.crm.web.dtos.ClientInputDTO;
import com.crm.web.exceptions.ResourceNotFoundException;
import com.crm.web.models.Client;
import com.crm.web.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }
    // Método que vai retornar todos os clientes
    public Iterable<Client> getClients() {

        return this.clientRepository.findAll();
    }

    // Método para adicionar cliente
    public Client addClient(ClientInputDTO client) {
        ModelMapper mapper = new ModelMapper();
        Client clientToPersist = mapper.map(client, Client.class); // Vai inferir o mapeamento de maneira direta, ou seja, se os nomes das propriedades foram iguais, ele vai mapear diretamente
        this.clientRepository.save(clientToPersist);
        return clientToPersist;
    }

    public Client getClientById(int idClient) {
        Optional<Client> client = this.clientRepository.findById(idClient);

        if(client.isEmpty()) {
            throw new ResourceNotFoundException("Client do not exist"); // Cliente não existe
        }

        return client.get();
    }

}
