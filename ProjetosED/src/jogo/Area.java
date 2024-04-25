package jogo;

import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class Area implements Atualizavel, Desenhavel {

    private Chao[][] chao;
    private int tamanhoX;
    private int tamanhoY;
    public static int tamanhoTotal;
    private int linha;
    private int coluna;

    public Area(int tamanhoX, int tamanhoY, int tamanhoChao) {

        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        chao = new Chao[tamanhoY][tamanhoX];

        tamanhoTotal = (tamanhoX * tamanhoY);
        for (int i = 0; i < tamanhoTotal; i++) {
            linha = i / tamanhoX;
            coluna = i % tamanhoX;
            chao[linha][coluna] = new Chao(
                    coluna * tamanhoChao, linha * tamanhoChao,
                    tamanhoChao, tamanhoChao
            );
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < tamanhoTotal; i++) {
            linha = i / tamanhoX;
            coluna = i % tamanhoX;
            if (PlayManager.player.posicao.coluna == coluna && PlayManager.player.posicao.linha == linha) {
                chao[linha][coluna].update();
            }

        }
    }

    @Override
    public void paint(Graphics2D g) {
        for (int i = 0; i < tamanhoTotal; i++) {
            linha = i / tamanhoX;
            coluna = i % tamanhoX;
            chao[linha][coluna].paint(g);

        }
    }

}
