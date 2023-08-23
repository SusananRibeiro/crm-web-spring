package com.crm.web.dtos.validations;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
@Documented //
@Constraint(validatedBy = CpfValidations.class) // dizer quem vai validar, nesse exemplo quem vai validar é a classe "CpfValidations.class"
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // dizer que a annotation "@Cpf" vai ser usada em tempo de execução
public @interface Cpf {
    String message() default "CPF inválido"; // message = mensagem

    Class<?>[] groups() default {}; // padrão das annotations, precisa colocar os grupos, "{}" diz que é vazio, que não pertence a nenhum grupo

    Class<? extends Payload>[] payload() default {};

}
