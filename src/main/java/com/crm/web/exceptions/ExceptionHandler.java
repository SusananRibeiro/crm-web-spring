package com.crm.web.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice// vai tratar as exceções dos controllers
@ResponseBody // representa que essa classe vai ter um body
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class) // "ResourceNotFoundException.class" é a classe que se está validando
    public ResponseEntity<ErrorMessage> notFound(ResourceNotFoundException exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimestamp(LocalDateTime.now().atZone(ZoneId.of("UTC")).toLocalDateTime());
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

}
