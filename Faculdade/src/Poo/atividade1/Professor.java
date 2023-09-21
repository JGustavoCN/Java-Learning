package poo.atividade1;

/**
 *
 * @author José Gustavo
 */

public class Professor {
    
    /**
     * Classe: Pessoa 
     * --> Atributos: 
     * nome String 
     * dataNascimento String
     * localNascimento String 
     * sexo char
     * formacao String
     * --> Metodos: 
     * dormir comer andar aplicarProva
     */
    
    private String nome;
    private String dataNascimento;
    private String localNascimento;
    private char sexo;
    private String formacao;
    
    public void dormir(){ System.out.println("Dormindo"); }
    
    public void comer(String comida){ System.out.println("Comendo " + comida); }
    
    public void andar(){ System.out.println("Andando..."); }
    
    public boolean aplicarProva(){ return true; }
    
}
