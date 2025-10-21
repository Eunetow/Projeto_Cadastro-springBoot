package com.cadastro.usuario.projeto_cadastro.service;


import com.cadastro.usuario.projeto_cadastro.exception.UserExistsExceptions;
import com.cadastro.usuario.projeto_cadastro.exception.UserNotExist;
import com.cadastro.usuario.projeto_cadastro.model.User;
import com.cadastro.usuario.projeto_cadastro.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UsuarioService {

    public static UsuarioRepository repo;
    private static final int MAX_ATTEMPS = 10;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public  void deletarUserPorEmail(String email) {
        if (repo.existsByEmail(email)) {
            repo.deleteByEmail(email);
        } else {
            throw new EntityNotFoundException("Usuário com email " + email + " não encontrado.");

        }
    }

    public void atualizarUserPorId(long id, User user) {
        User userEntity = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario nao encontrado"));
        User userAtualizado = new User();
        if (user.getEmail() != null) {
            userEntity.setEmail(user.getEmail());
        }
        if (user.getNome() != null) {
            userEntity.setNome(user.getNome());
        }

        repo.save(userEntity);
    }

    public  User buscarUserPorEmail(String email) {
        return repo.findByEmail(email).orElseThrow(
                () -> new UserNotExist()
        );
    }


    public List<User> listarUser() {
        return repo.findAll();
    }

    public User salvar(User user) {
        if (repo.existsByEmail(user.getEmail())){
            throw new UserExistsExceptions();
        }
        return repo.save(user);
    }

    @Transactional
    public User createUserWithRandomCode(String nome, String email){
        for (int attemps = 0; attemps < MAX_ATTEMPS; attemps++) {
            String code = generate1to5Digits();
         if (!repo.existsByUserCode(code))  {
             User u = new User();
             u.setNome(nome);
             u.setEmail(email);
             u.setUserCode(code);
             return salvar(u);
         }


        }
        throw new IllegalStateException("Não foi possivel gerar um código unico após"+ MAX_ATTEMPS + "tentativas");

    }

    private String generate1to5Digits(){
        int n = ThreadLocalRandom.current().nextInt(1,1000);
        return String.valueOf(n);
    }




}
