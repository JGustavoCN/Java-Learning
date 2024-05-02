package jogo.models;

import jogo.main.PlayManager;
import java.awt.Graphics2D;
import jogo.abstracts.Atualizavel;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Formato;

/**
 *
 * @author José Gustavo
 */
public class Mapa implements Atualizavel, Desenhavel {

    public final Chao[][] chao;
    private final int tamanhoX;
    private final int tamanhoY;
    private final int tamanhoTotal;
    private int linha;
    private int coluna;

    public Mapa(int tamanhoX, int tamanhoY, int tamanhoChao) {

        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        chao = new Chao[tamanhoY][tamanhoX];

        tamanhoTotal = (tamanhoX * tamanhoY);
        for (int i = 0; i < tamanhoTotal; i++) {
            linha = i / tamanhoX;
            coluna = i % tamanhoX;
            chao[linha][coluna] = 
                new Chao( 
                    new Formato (
                        coluna * tamanhoChao, linha * tamanhoChao,
                        tamanhoChao, tamanhoChao
                    )
                );
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < tamanhoTotal; i++) {
            linha = i / tamanhoX;
            coluna = i % tamanhoX;
            if (PlayManager.jogador.posicao.coluna == coluna && PlayManager.jogador.posicao.linha == linha) {
                chao[linha][coluna].update();
                PlayManager.isChegou();
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

    public int getTamanhoX() {
        return tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public int getTamanhoTotal() {
        return tamanhoTotal;
    }


}
