package jogo.models;

import jogo.main.PlayManager;
import java.awt.Graphics2D;
import jogo.abstracts.Atualizavel;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Formato;
import jogo.models.Chao.Terra;

/**
 *
 * @author José Gustavo
 */
public class Mapa implements Atualizavel, Desenhavel {

    public Chao[][] chao;
    public Cerca[] cercas;
    public Terra[] terras;
    private int tamanhoX;
    private int tamanhoY;
    private int tamanhoTotal;
    private int linha;
    private int coluna;

    public Mapa(int tamanhoX, int tamanhoY, int tamanhoChao) {

        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        chao = new Chao[tamanhoY][tamanhoX];
        int borda = 100;
        tamanhoTotal = (tamanhoX * tamanhoY);
        for (int i = 0; i < tamanhoTotal; i++) {
            linha = i / tamanhoX;
            coluna = i % tamanhoX;
            chao[linha][coluna]
                    = new Chao(
                            new Formato(
                                    borda + coluna * tamanhoChao, borda + linha * tamanhoChao,
                                    tamanhoChao, tamanhoChao
                            )
                    );
        }
        cercas = new Cerca[22];
        for (int i = 0; i < cercas.length; i++) {
            if (i == 0) {
                cercas[i] = new Cerca(Cerca.CANTO_SE, new Formato(i * tamanhoChao, 0, tamanhoChao, tamanhoChao));
            } else if (i < 6) {
                cercas[i] = new Cerca(Cerca.MEIO_H, new Formato(i * tamanhoChao, 0, tamanhoChao, tamanhoChao));
            } else if (i == 6) {
                cercas[i] = new Cerca(Cerca.CANTO_SD, new Formato(i * tamanhoChao, 0, tamanhoChao, tamanhoChao));
            } else if (i == 7) {
                cercas[i] = new Cerca(Cerca.CANTO_SE_2, new Formato(0, 200, tamanhoChao, tamanhoChao));
            } else if (i < 11) {
                cercas[i] = new Cerca(Cerca.MEIO_V, new Formato(0, (i % 8 * 100) + 300, tamanhoChao, tamanhoChao));
            } else if (i < 14) {
                cercas[i] = new Cerca(Cerca.MEIO_V, new Formato(600, (i % 11 * 100) + 100, tamanhoChao, tamanhoChao));
            } else if (i == 14) {
                cercas[i] = new Cerca(Cerca.CANTO_ID, new Formato(600, 400, tamanhoChao, tamanhoChao));
            } else if (i == 15) {
                cercas[i] = new Cerca(Cerca.CANTO_IE, new Formato(0, 600, tamanhoChao, tamanhoChao));
            } else if (i < 21) {
                cercas[i] = new Cerca(Cerca.MEIO_H, new Formato((i % 16 * 100) + 100, 600, tamanhoChao, tamanhoChao));
            } else {
                cercas[i] = new Cerca(Cerca.CANTO_ID_2, new Formato(600, 600, tamanhoChao, tamanhoChao));
            }
        }
        terras = new Terra[2];
        terras[0] = new Terra();
        terras[0].setFormato(new Formato(0, 100, tamanhoChao, tamanhoChao));
        terras[1] = new Terra();
        terras[1].setFormato(new Formato(600, 500, tamanhoChao, tamanhoChao));
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
        for (Cerca cerca : cercas) {
            cerca.paint(g);
        }
        for (Terra terra : terras) {
            terra.paint(g);
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
