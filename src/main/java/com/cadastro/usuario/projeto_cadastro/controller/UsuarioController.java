package com.cadastro.usuario.projeto_cadastro.controller;


import com.cadastro.usuario.projeto_cadastro.model.User;
import com.cadastro.usuario.projeto_cadastro.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cadastro.usuario.projeto_cadastro.service.UsuarioService.repo;

@RestController
@RequestMapping("/api/Cadastro")
public class UsuarioController {

    private final UsuarioService svc;

    public UsuarioController(UsuarioService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserRequest req) {
        User saved = svc.createUserWithRandomCode(req.getNome(), req.getEmail());
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<User> buscarUserPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(svc.buscarUserPorEmail(email));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarUserPorEmail(@RequestParam String email) {
        svc.deletarUserPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUserPorId(@PathVariable long id,
                                                   @RequestBody User user) {
       svc.atualizarUserPorId(id, user);
        return ResponseEntity.ok().build();

    }


    public static class CreateUserRequest {
        private String nome;


        public String getNome() {

            return nome;
        }

        public void setNome(String nome) {

            this.nome = nome;
        }

        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
}



