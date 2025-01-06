package br.douglas.dogi.dogi.dtos;

public class ClienteInsertDTO extends ClienteDTO{

    private String senha;
    private String cpf;

    public ClienteInsertDTO() {
        super();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
