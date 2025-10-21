package com.cadastro.usuario.projeto_cadastro.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GoblalExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserExistsExceptions.class)
    private ResponseEntity<ErroMessenger> emailExisting (UserExistsExceptions exceptions) {
        ErroMessenger threatError = new ErroMessenger(INTERNAL_SERVER_ERROR,exceptions.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(threatError);
    }

    @ExceptionHandler(UserNotExist.class)
    private ResponseEntity<ErroMessenger> emailNotExisting (UserNotExist exceptions) {
        ErroMessenger threatError = new ErroMessenger(NOT_FOUND,exceptions.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatError);
    }


}
