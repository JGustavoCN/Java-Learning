package jogo;

import java.awt.Graphics2D;

/**
 *
 * @author Aluno
 */
public class Player implements Desenhavel, Atualizavel {

    Posicao posicao;

    public Player() {
        posicao = new Posicao(0, 0);
    }

    // colocar ele para saber qual direcao vai? direita() esquerda() cimaEsquerda()
    public void mover(int linha, int coluna) {
        posicao.mover(linha, coluna);
    }

    public void direita() {
        posicao.coluna += 1;
    }

    public void baixo() {
        posicao.linha += 1;
    }

    public void cima() {
        posicao.linha -= 1;
    }

    public void esquerda() {
        posicao.coluna -= 1;
    }

    @Override
    public void paint(Graphics2D g) {

    }

    @Override
    public void update() {

    }

}
