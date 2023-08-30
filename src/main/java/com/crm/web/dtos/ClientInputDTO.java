package com.crm.web.dtos;
import com.crm.web.dtos.validations.Cpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // vai configurar um construtor com todos os parâmetros
@NoArgsConstructor
public class ClientInputDTO {
    @Cpf
    private String cpf;
    @NotBlank // campo obrigatório, é uma validação
    private String primeiroNome;
    @NotBlank // campo obrigatório, é uma validação
    private String sobrenome;
    private int idade;
    @NotBlank // campo obrigatório, é uma validação
    @Email
    private String email;

}
