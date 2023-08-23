package com.crm.web.service;
import com.crm.web.dtos.ClientInputDTO;
import com.crm.web.models.Client;
import com.crm.web.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ClientServiceTest {

    private static ClientService clientService;
    private static ClientRepository clientRepository; // Precisa Mocka o repositório

    @BeforeAll
    static void setup() {
        clientRepository = Mockito.mock(ClientRepository.class); // "Mockito.mock()" á para criar uma instância falsa da classe "ClientRepository"
        clientService = new ClientService(clientRepository); // o ClientService precisa do ClientRepository, por isso se mocka, para poder usar no ClientService
    }
    @Test
    public void AddClientCreateClientSuccess() {
        // Arrange
        String fakeValueClient = "test";

// Não precisaria dessa parte por causa do "assertEquals();" no Assert, mas como precisa do ClientRepository, precisa ter
        Client client = new Client();
        client.setId(1);
        client.setCpf(fakeValueClient);
        client.setPrimeiroNome(fakeValueClient);
        client.setSobrenome(fakeValueClient);
        client.setIdade(25);
        client.setEmail(fakeValueClient);

        ClientInputDTO clientInputDTO = new ClientInputDTO();
        clientInputDTO.setCpf(fakeValueClient);
        clientInputDTO.setPrimeiroNome(fakeValueClient);
        clientInputDTO.setSobrenome(fakeValueClient);
        clientInputDTO.setIdade(25);
        clientInputDTO.setEmail(fakeValueClient);
        doReturn(client).when(clientRepository).save(ArgumentMatchers.any());// é uma configuração de retorno do repositorio

        // Act
        Client retornoClient = clientService.addClient(clientInputDTO);

        // Assert
        assertEquals(fakeValueClient, clientInputDTO.getCpf()); // primeiro parâmetro o que se quer, o segundo parâmetro é o que foi retornado
        assertEquals(fakeValueClient, clientInputDTO.getPrimeiroNome());
        assertEquals(fakeValueClient, clientInputDTO.getSobrenome());
        assertEquals(25, clientInputDTO.getIdade());
        assertEquals(fakeValueClient, clientInputDTO.getEmail());


    }
}
