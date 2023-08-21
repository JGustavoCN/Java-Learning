package dominio;

public class Pessoa {

    private String nome;
    private int idade;
    private char sexo;
    private Livro livros[];
   
    
    public Pessoa(){
        
    }
    
    public Pessoa(String nome, int idade, char sexo) {
        
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Pessoa(String nome, int idade, char sexo, Livro[] livros) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.livros = livros;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro... livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = Character.toUpperCase(sexo);
    }

    public void fazerAniver() {
        this.idade++;
    }
    
    public void detalhes() {
        System.out.println("===================================");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Sexo: " + this.sexo);
        System.out.print("Livros que esta lendo: ");
        
        for (Livro livro : livros) {
            if (livro.getNome() != null || livros.length == 0)
            System.out.println(livro.getNome());
        }
        System.out.println("===================================");
    }
}
