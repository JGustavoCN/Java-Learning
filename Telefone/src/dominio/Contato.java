package dominio;

public class Contato {

    private static int contador;
    
    private String nome;
    private int telefone;
    private final int identificador;

    public Contato(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
        contador++;
        this.identificador = contador + 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", telefone=" + telefone + ", identificador=" + identificador + '}';
    }

}
