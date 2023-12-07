package br.edu.ifs.poo.projeto.model;

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

    @Override
	public String toString() {
		return "\nProfessor" + super.toString() + "Formação = " + formacao + " | Quant. de Disciplinas = " + quantDisciplinas + " ]\n";
	}
}
