package br.edu.ifs.poo.projeto.model;

public class Candidato extends Pessoa {

    private String dataConcurso;
    private int codigoVaga;
    private int pontuacao;

    public String getDataConcurso() {
        return dataConcurso;
    }

    public void setDataConcurso(String dataConcurso) {
        this.dataConcurso = dataConcurso;
    }

    public int getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(int codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "\nCandidato" + super.toString() + "Data do Concurso = " + dataConcurso + " | Código de Vaga = " + codigoVaga + " | Pontuação = " + pontuacao + " ]\n";
    }

}
