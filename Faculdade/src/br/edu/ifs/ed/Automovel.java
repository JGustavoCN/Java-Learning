package br.edu.ifs.ed;

/**
 *
 * @author José Gustavo
 */
public class Automovel {
    
    private String nome;
    private String marca;
    private String cor;

    public Automovel(String nome, String marca, String cor) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Automovel{" + "nome=" + nome + ", marca=" + marca + ", cor=" + cor + '}';
    }
    
    
    
}
