package br.edu.ifs.poo.projeto.model;

public class Zelador extends Pessoa {

    private String setorResponsavel;
    private boolean possuiChave;

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;    
    }    
 
    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setPossuiChave(boolean possuiChave) {
        this.possuiChave = possuiChave;
    }

    public boolean getPossuiChave() {
        return possuiChave;
    }

    @Override
	public String toString() {
		return "\nZelador" + super.toString() + "Setor = " + setorResponsavel + " | Possui chave = " + possuiChave + " ]\n";
	}
    
}
