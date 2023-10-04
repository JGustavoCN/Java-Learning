package poo.atividade1;

/**
 *
 * @author José Gustavo
 */
public class Psicologo extends Pessoa {
   
    // Crie os getters e setters da classe
    
    private int crp;
    private String especialidade;

    public int getCrp() {
        return crp;
    }

    public void setCrp(int crp) {
        this.crp = crp;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
   
}
