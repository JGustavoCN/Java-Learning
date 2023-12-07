package br.edu.ifs.poo.projeto.model;


public class Secretaria extends Pessoa {
    private String departamento;
    private int ramal;
    private String funcaoS;
    private String turno;

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getDepartamento() {
        return departamento;
    }   

    // Ramal é um número acossiado a um telefone dentro da organização
    public void setRamal(int ramal) {
        this.ramal = ramal;
    }
    public int getRamal() {
        return ramal;
    }
    
    public void setFuncaoS(String funcaoS) {
        this.funcaoS = funcaoS;
    }
    public String getFuncaoS() {
        return funcaoS;
    }
   
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getTurno() {
        return turno;
    }
    
    @Override
    public String toString() {
        return "\nSecretaria" + super.toString() + "Departament = " + departamento + " | Ramal = " + ramal + " | Função = " + funcaoS + " | Turno = " + turno + " ]\n";
    }

}
