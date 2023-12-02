package util;

import exception.CNHException;
import exception.CPFException;
import exception.EmailException;

import java.util.Date;
import java.util.regex.Pattern;

public class ClienteValidator {
    public static void validateCPF(String cpf) throws CPFException {

//        throw new CPFException("CPF Invalido");
    }

    public static void validateEmail(String email) throws EmailException {
        var regexPattern = "^(.+)@(\\S+)$";
        var doesMatch = Pattern.compile(regexPattern).matcher(email).matches();
        if (!doesMatch) {
            throw new EmailException("Email invalido");
        }
    }

    public static void validateCNH(String cnh) throws CNHException {
//        throw new CNHException("CNH Invalido");
    }

    public static void validateValidadeCNH(Date validadeCNH) throws CNHException {
//        throw new CNHException("Validade do CNH invalida!");
    }
}
