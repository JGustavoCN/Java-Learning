package Poo.projeto.model;

public class Psicologo extends Pessoa {

    private int crp;
    private String especialidade;

    public void setCrp(int crp) {
        this.crp = crp;
    }
    public int getCrp() {
        return this.crp;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getEspecialidade() {
        return this.especialidade;
    }
}
