package jogo.abstracts;

/**
 *
 * @author José Gustavo
 */
public class Posicao {

    public int linha;
    public int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void mover(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return "Posicao{" + "linha=" + linha + ", coluna=" + coluna + '}';
    }
    

}
