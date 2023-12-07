package br.edu.ifs.poo.projeto.model;

public class Responsavel extends Pessoa {

    private String parentesco;
    private double renda;

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    public String getParentesco() {
        return this.parentesco;
    }
    
    public void setRenda(double renda) {
        this.renda = renda;
    }
    public double getRenda() {
        return this.renda;
    }

    @Override
	public String toString() {
		return "\nResponsável" + super.toString() + "Parentesco = " + parentesco + " | Renda = " + renda + " ]\n";
	}
}
