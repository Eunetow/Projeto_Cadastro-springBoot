package com.cadastro.usuario.projeto_cadastro.exception;

public class UserExistsExceptions extends RuntimeException{

    public UserExistsExceptions() {
        super("Email ja existe!");
    }

    public UserExistsExceptions(String mensagem) {
        super(mensagem);
    }
}
