package jogo.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import jogo.abstracts.*;
import jogo.models.*;

/**
 *
 * @author José Gustavo
 */
public class PlayManager implements Desenhavel, Atualizavel {

    public static Mapa mapa;
    public static GPS GPS;
    public static Jogador jogador;
    public static final Posicao posicaoInicial = new Posicao(0, 0);
    public static boolean chegou;

    public PlayManager() {
        jogador = new Jogador(new Posicao(posicaoInicial.linha, posicaoInicial.coluna));
        mapa = new Mapa(5, 5, 100);
        GPS = new GPS(mapa);
    }

    @Override
    public void paint(Graphics2D g2) {

        mapa.paint(g2);
        jogador.paint(g2);

        if (chegou) {
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Para verificar click 'v'", 80, 250);
            GPS.paint(g2);
            if (KeyHandler.verificar && !GPS.temCaminho()) {
                GPS.verificarCaminhos(new Posicao(posicaoInicial.linha, posicaoInicial.coluna));
                KeyHandler.verificar = false;
            }
        }

    }

    @Override
    public void update() {
        mapa.update();
        jogador.update();
    }

    public static boolean isChegou() {
        chegou = jogador.posicao.linha == mapa.getTamanhoY() - 1 && jogador.posicao.coluna == mapa.getTamanhoY() - 1;
        return chegou;
    }

    public static Local posicaoJogador() {
        if (isChegou()) {
            return Local.CANTO_INFERIOR_DIREITO;
        }
        int linha = jogador.posicao.linha;
        int coluna = jogador.posicao.coluna;
        int tamanhoX = mapa.getTamanhoX();
        int tamanhoY = mapa.getTamanhoY();

        if (linha == 0 && coluna == 0) {
            return Local.CANTO_SUPERIOR_ESQUERDO;
        } else if (linha == 0 && coluna > 0 && coluna < tamanhoX - 1) {
            return Local.MEIO_SUPERIOR;
        } else if (linha == 0 && coluna == tamanhoX - 1) {
            return Local.CANTO_SUPERIOR_DIREITO;
        } else if (linha > 0 && linha < tamanhoY - 1 && coluna == 0) {
            return Local.MEIO_ESQUERDO;
        } else if (linha > 0 && linha < tamanhoY - 1 && coluna > 0 && coluna < tamanhoX - 1) {
            return Local.MEIO;
        } else if (linha > 0 && linha < tamanhoY - 1 && coluna == tamanhoX - 1) {
            return Local.MEIO_DIREITO;
        } else if (linha == tamanhoY - 1 && coluna == 0) {
            return Local.CANTO_INFERIOR_ESQUERDO;
        } else if (linha == tamanhoY - 1 && coluna > 0 && coluna < tamanhoX - 1) {
            return Local.MEIO_INFERIOR;
        } else {
            System.out.println("Posiçao não encontrada");
            return null;
        }
    }

}
