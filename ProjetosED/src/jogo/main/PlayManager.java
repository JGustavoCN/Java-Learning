package jogo.main;

import java.awt.Graphics2D;
import jogo.abstracts.Atualizavel;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Local;
import jogo.models.Mapa;
import jogo.models.Player;
import jogo.abstracts.Posicao;

/**
 *
 * @author José Gustavo
 */
public class PlayManager implements Desenhavel, Atualizavel {

    public static Mapa mapa;
    public static Player player;
    public static Local local;
    public static boolean chegou;

    public PlayManager() {
        player = new Player();
        mapa = new Mapa(5, 5, 100);
    }

    @Override
    public void paint(Graphics2D g2) {

        mapa.paint(g2);
        player.paint(g2);

    }

    @Override
    public void update() {
        local = posicao(mapa, player);
        mapa.update();
        player.update();
        
    }

    public static boolean isChegou(Mapa mapa, Player jogador) {
        chegou = jogador.posicao.linha == mapa.getTamanhoY() - 1 && jogador.posicao.coluna == mapa.getTamanhoY() - 1;
        return chegou;
    }

    public static Local posicao(Mapa mapa, Player jogador) {
        if (isChegou(mapa, jogador)) return Local.CANTO_INFERIOR_DIREITO;
        int linha = jogador.posicao.linha;
        int coluna = jogador.posicao.coluna;
        System.out.println(linha +" - "+coluna);
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

    public static boolean verificarCaminho(int[][] matriz, Posicao posicaoAtual, Posicao posicaoAnterior) {

        if (matriz.length - 1 == posicaoAtual.linha && matriz[0].length - 1 == posicaoAtual.coluna) {
            return true;
        }

        int formatoCaminho = 1;
        boolean caminhoDireita = false;
        boolean caminhoBaixo = false;
        boolean caminhoEsquerda = false;
        boolean caminhoCima = false;

        if (posicaoAtual.coluna < matriz[0].length - 1 && posicaoAnterior.coluna != posicaoAtual.coluna + 1 && matriz[posicaoAtual.linha][posicaoAtual.coluna + 1] == formatoCaminho) {
            caminhoDireita = verificarCaminho(matriz, new Posicao(posicaoAtual.linha, posicaoAtual.coluna + 1), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }

        if (posicaoAtual.linha < matriz.length - 1 && posicaoAnterior.linha != posicaoAtual.linha + 1 && matriz[posicaoAtual.linha + 1][posicaoAtual.coluna] == formatoCaminho) {
            caminhoBaixo = verificarCaminho(matriz, new Posicao(posicaoAtual.linha + 1, posicaoAtual.coluna), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }

        if (posicaoAtual.coluna > 0 && posicaoAnterior.coluna != posicaoAtual.coluna - 1 && matriz[posicaoAtual.linha][posicaoAtual.coluna - 1] == formatoCaminho) {
            caminhoEsquerda = verificarCaminho(matriz, new Posicao(posicaoAtual.linha, posicaoAtual.coluna - 1), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }

        if (posicaoAtual.linha > 0 && posicaoAnterior.linha != posicaoAtual.linha - 1 && matriz[posicaoAtual.linha - 1][posicaoAtual.coluna] == formatoCaminho) {
            caminhoCima = verificarCaminho(matriz, new Posicao(posicaoAtual.linha - 1, posicaoAtual.coluna), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }

        return caminhoEsquerda || caminhoBaixo || caminhoDireita || caminhoCima;

    }

}
