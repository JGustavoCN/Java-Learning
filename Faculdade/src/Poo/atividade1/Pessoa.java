package poo.atividade1;

/**
 *
 * @author José Gustavo
 */

public class Pessoa {
    
    /**
     * Classe: Pessoa 
     * --> Atributos: 
     * nome String 
     * dataNascimento String
     * localNascimento String 
     * sexo char 
     * --> Metodos: 
     * dormir comer andar falar
     */
    
    private String nome;
    private String dataNascimento;
    private String localNascimento;
    private char sexo;
    
    public void dormir(){ System.out.println("Dormindo"); }
    
    public void comer(String comida){ System.out.println("Comendo " + comida); }
    
    public void andar(){ System.out.println("Andando..."); }
    
    public String falar(){ return "Alguma coisa"; }
    
}
