package com.crm.web.dtos.validations;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
Precisa implementar a classe ConstraintValidator, precisa passar qual annotation ela vai validar, neste caso "Cpf"
e também qual o tipo do valor que ela vai validar, neste caso uma String, ficando assim  o resultado final
"public class CpfValidations implements ConstraintValidator<Cpf, String>"
*/
public class CpfValidations implements ConstraintValidator<Cpf, String> {
    private final int[] PESO_CPF = {10, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {

        String cpfSomenteDigitos = cpf.replaceAll("\\D", "");

        if((cpfSomenteDigitos == null) || (cpfSomenteDigitos.length() != 11) || cpfSomenteDigitos.equals("00000000000")
             || cpfSomenteDigitos.equals("11111111111") || cpfSomenteDigitos.equals("22222222222")
             || cpfSomenteDigitos.equals("33333333333") || cpfSomenteDigitos.equals("44444444444")
             || cpfSomenteDigitos.equals("55555555555") || cpfSomenteDigitos.equals("66666666666")
             || cpfSomenteDigitos.equals("77777777777") || cpfSomenteDigitos.equals("88888888888")
             || cpfSomenteDigitos.equals("99999999999")) {
            return false;
        }

        Integer digito1 = calcularDigito(cpfSomenteDigitos.substring(0, 9), PESO_CPF);
        Integer digito2 = calcularDigito(cpfSomenteDigitos.substring(0, 9) + digito1, PESO_CPF);
        return cpfSomenteDigitos.equals(cpfSomenteDigitos.substring(0, 9) + digito1.toString() + digito2.toString());

    }

    private int calcularDigito(String str, int[] peso) {
        int soma= 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--){
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }


}
