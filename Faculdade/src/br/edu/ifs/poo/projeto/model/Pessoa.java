package br.edu.ifs.poo.projeto.model;

public class Pessoa {

    private String nome;
    private String dataNascimento;
    private String localNascimento;
    private char sexo;
    private long cpf;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public String getLocalNascimento() {
        return this.localNascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = Character.toUpperCase(sexo);
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return " [ Nome = " + nome + " | Data de Nascimento = " + dataNascimento + " | Local de Nascimento = " + localNascimento
                + " | Sexo(M/F) = " + sexo + " | CPF = " + cpf + " | ";
    }
}
