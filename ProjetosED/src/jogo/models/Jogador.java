package jogo.models;

import java.awt.Graphics2D;
import jogo.abstracts.Atualizavel;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Desenho;
import jogo.abstracts.Formato;
import jogo.abstracts.Posicao;
import jogo.main.KeyHandler;
import jogo.main.PlayManager;

/**
 *
 * @author Aluno
 */
public class Jogador implements Desenhavel, Atualizavel {

    public class DesenhoPlayer extends Desenho {

        public DesenhoPlayer(String localizacaoDaImagem, String nome) {
            super(localizacaoDaImagem, nome);
        }
    }

    public Posicao posicao;
    public Desenho[] desenho = new Desenho[8];
    private int indexDesenho;

    public Jogador(Posicao posicaoInicial) {
        posicao = posicaoInicial;
        indexDesenho = 4;
        for (int i = 0; i < desenho.length; i++) {
            desenho[i] = new DesenhoPlayer("src/jogo/imagens/trator/trator" + (i + 1) + ".png", "trator" + (i + 1));
            desenho[i].setFormato(new Formato(0, 100, 100, 100));
        }
    }

    @Override
    public void paint(Graphics2D g) {
        desenho[indexDesenho].paint(g);
    }


    @Override
    public void update() {
        if (PlayManager.chegou) {
            indexDesenho = 4;
            desenho[indexDesenho].setFormato(new Formato(600, 500, 100, 100));
        } else {
            if (KeyHandler.cantoSupE) {
                diagonalSE();
                indexDesenho = 0;
                KeyHandler.cantoSupE = false;
            } else if (KeyHandler.cima) {
                cima();
                indexDesenho = 1;
                KeyHandler.cima = false;
            } else if (KeyHandler.cantoSupD) {
                diagonalSD();
                indexDesenho = 2;
                KeyHandler.cantoSupD = false;
            } else if (KeyHandler.esquerda) {
                esquerda();
                indexDesenho = 3;
                KeyHandler.esquerda = false;
            } else if (KeyHandler.direita) {
                direita();
                indexDesenho = 4;
                KeyHandler.direita = false;
            } else if (KeyHandler.cantoInfE) {
                diagonalIE();
                indexDesenho = 5;
                KeyHandler.cantoInfE = false;
            } else if (KeyHandler.baixo) {
                baixo();
                indexDesenho = 6;
                KeyHandler.baixo = false;
            } else if (KeyHandler.cantoInfD) {
                diagonalID();
                indexDesenho = 7;
                KeyHandler.cantoInfD = false;
            }

            desenho[indexDesenho].formato.x = PlayManager.mapa.chao[posicao.linha][posicao.coluna].formato.x;
            desenho[indexDesenho].formato.y = PlayManager.mapa.chao[posicao.linha][posicao.coluna].formato.y;
        }
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

    public void diagonalSE() {
        cima();
        esquerda();
    }

    public void diagonalSD() {
        cima();
        direita();
    }

    public void diagonalIE() {
        baixo();
        esquerda();
    }

    public void diagonalID() {
        baixo();
        direita();
    }
}
