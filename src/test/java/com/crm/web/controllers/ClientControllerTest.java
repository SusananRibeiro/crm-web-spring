package com.crm.web.controllers;
import com.crm.web.dtos.ClientInputDTO;
import com.crm.web.exceptions.ExceptionHandler;
import com.crm.web.models.Client;
import com.crm.web.rest.ClientController;
import com.crm.web.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // para rodar em uma porta Randomica
public class ClientControllerTest {
    @Mock // usar essa anotação para não precisar instanciar a classe "ClientService"
    private ClientService clientService;
    private MockMvc mockMvc; // esse comando serve para fazer a chamada por fora do protocolo HTTP, Cria um cliente fictício para fazer a chamada externa do HTTP

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // vai configurar todos os mockis
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ClientController(clientService))
                .setControllerAdvice(new ExceptionHandler()).build(); // vai mocka o ClientService
    }

    @Test // essa annotation é para mostrar que é um método de teste
    public void getByIdValidIdShoulReturnSucecess200Ok() throws Exception {
        // Arrange
        String path = "/client/{clientId}"; // endpoint
        Integer clientId = 10;
        Integer idadeFake = 25;
        String fakeValue = "fakeValue";

        Client expectedClient = new Client(clientId, fakeValue,  fakeValue,  fakeValue, idadeFake, fakeValue);

        Mockito.when(clientService.getClientById(clientId)).thenReturn(expectedClient); // mocka a chamada para o ClientService

        /* Act e Assert
        ACT seria "this.mockMvc.perform(get(path, clientId).contentType(MediaType.APPLICATION_JSON))"
        ASSERT seria ".andExpect(status().isOk()).andExpect(jsonPath("$.id").value(clientId));"
        */
        this.mockMvc.perform(get(path, clientId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clientId)); // vai executar a chamada de fato, nessa parte ainda não está configurado o service

    }

    //Para testar passando valores inválidos
    @Test
    public void addClientInvalidValuesShouldReturn400BadRequest() throws Exception {
        String path = "/client";
        String fakeValue = "fakeValue";
        Integer idadeFake = 30;
        ClientInputDTO inputDTO = new ClientInputDTO(fakeValue, fakeValue, fakeValue, idadeFake, fakeValue);

        this.mockMvc.perform(
                post(path).contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputDTO))
        ).andExpect(status().isBadRequest());
    }

}
