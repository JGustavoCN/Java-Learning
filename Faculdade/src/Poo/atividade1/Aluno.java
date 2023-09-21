package poo.atividade1;

/**
 *
 * @author José Gustavo
 */

public class Aluno {
    
    /**
     * Classe: Pessoa 
     * --> Atributos: 
     * nome String 
     * dataNascimento String
     * localNascimento String 
     * sexo char 
     * nota1 double
     * nota2 double
     * --> Metodos: 
     * dormir comer andar falar fazerProva
     */
    
    private String nome;
    private String dataNascimento;
    private String localNascimento;
    private char sexo;
    private double nota1;
    private double nota2;
    
    public void dormir(){ System.out.println("Dormindo"); }
    
    public void comer(String comida){ System.out.println("Comendo " + comida); }
    
    public void andar(){ System.out.println("Andando..."); }
    
    public String falar(){ return "Alguma coisa"; }
    
    public String fazerProva(String prova){ return "Alguma coisa"; }
    
}
