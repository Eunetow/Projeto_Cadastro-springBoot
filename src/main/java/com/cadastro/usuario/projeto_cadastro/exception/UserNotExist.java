package com.cadastro.usuario.projeto_cadastro.exception;

public class UserNotExist extends RuntimeException {

    public UserNotExist() {
        super("Email nao Encontrado");
    }

    public UserNotExist(String mensagem) {
        super(mensagem);
    }
}
