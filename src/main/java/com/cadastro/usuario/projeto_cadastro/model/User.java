package com.cadastro.usuario.projeto_cadastro.model;


import jakarta.persistence.*;

@Entity
@Table(name= "Cadastro", uniqueConstraints = {@UniqueConstraint(name = "uk_user_code", columnNames = "user_code")})
public class User {

    public User(){

    }

    public User(long id, String nome, String email, String userCode) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.userCode = userCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String nome;

    @Column(name = "user_code", length = 5, nullable = false, unique = true)
    private String userCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
