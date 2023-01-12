package br.com.cce.teste.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ApiException extends  Exception {
    public  ApiException(String mensagem){
        super(mensagem);
    }
}
