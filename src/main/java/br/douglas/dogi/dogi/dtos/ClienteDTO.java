package br.douglas.dogi.dogi.dtos;

import java.time.Instant;
import java.time.LocalDate;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;

    public ClienteDTO() {

    }

    public ClienteDTO(Long id, String nome, String sobrenome, String telefone, String email, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
