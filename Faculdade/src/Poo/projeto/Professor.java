package poo.projeto;

public class Professor extends Pessoa {
    
    private String formacao;
    private int quantDisciplinas;

    public void setFormacao(String formacao) {
         this.formacao = formacao;
    }  
    public String getFormacao() {
        return this.formacao;   
    }   
    
    public void setQuantDisciplinas(int quantDisciplinas) {
        this.quantDisciplinas = quantDisciplinas;
    }
    public int getQuantDisciplinas() {
        return quantDisciplinas;
    }
}
