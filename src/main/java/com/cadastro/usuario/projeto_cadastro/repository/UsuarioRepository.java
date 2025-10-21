package com.cadastro.usuario.projeto_cadastro.repository;


import com.cadastro.usuario.projeto_cadastro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {
    boolean existsByUserCode(String userCode);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
}
