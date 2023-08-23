package com.crm.web.exceptions;
import lombok.Data;
import java.time.LocalDateTime;
@Data// para gerar os métodos Getters e Stters
public class ErrorMessage {
    private int statusCode; // o status que vai ser retornado
    private LocalDateTime timestamp; // vai dizer o momento que o erro ocorreu
    private String message; // vai ser a mensagem exibida na tela
}
