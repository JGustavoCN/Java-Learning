package br.edu.ifs.poo.projeto.model;

public class Pedagogo extends Pessoa {
    
    private int registro;

    public void setRegistro(int registro) {
        this.registro = registro;
    }
    public int getRegistro() {
        return this.registro;
    }

    @Override
	public String toString() {
		return "\nPedagogo" + super.toString() + "Registro = " + registro + " ]\n";
	}
}