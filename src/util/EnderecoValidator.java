package util;

import exception.CEPException;
import exception.NumeroEnderecoException;
import exception.RuaException;

public class EnderecoValidator {
    public static void validateRua(String rua) throws RuaException {
        if (rua.matches(".*\\d.*")) {
            throw new RuaException("Nome de rua invalido");
        }
    }

    public static void validateNumero(String numero) throws NumeroEnderecoException {

    }

    public static void validateCEP(String cep) throws CEPException {

    }
}
