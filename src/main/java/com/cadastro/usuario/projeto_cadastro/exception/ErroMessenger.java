package com.cadastro.usuario.projeto_cadastro.exception;

import org.springframework.http.HttpStatus;


public class ErroMessenger {
    private HttpStatus status;
    private String Mensagem;

    public ErroMessenger(HttpStatus status, String mensagem) {
        this.status = status;
        Mensagem = mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }
}
