package jogo;

import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class PlayManager implements Desenhavel, Atualizavel {

    public static Area area;
    public static Player player;
    public static Local local;

    public PlayManager() {
        player = new Player();
        area = new Area(5, 5, 100);
    }

    @Override
    public void paint(Graphics2D g2) {

        area.paint(g2);

    }

    @Override
    public void update() {
        area.update();
    }

    public static boolean cheguei(int[][] matriz, Player jogador) {
        return jogador.posicao.linha == matriz.length - 1 && jogador.posicao.coluna == matriz[0].length - 1;
    }

    public static Local posicao(int[][] matriz, Player jogador) {

        int linha = jogador.posicao.linha;
        int coluna = jogador.posicao.coluna;
        if (linha == 0 && coluna == 0) {
            return Local.CANTO_SUPERIOR_ESQUERDO;
        } else if (linha == 0 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO_SUPERIOR;
        } else if (linha == 0 && coluna == matriz[0].length - 1) {
            return Local.CANTO_SUPERIOR_DIREITO;
        } else if (linha > 0 && linha < matriz.length - 1 && coluna == 0) {
            return Local.MEIO_ESQUERDO;
        } else if (linha > 0 && linha < matriz.length - 1 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO;
        } else if (linha > 0 && linha < matriz.length - 1 && coluna == matriz[0].length - 1) {
            return Local.MEIO_DIREITO;
        } else if (linha == matriz.length - 1 && coluna == 0) {
            return Local.CANTO_INFERIOR_ESQUERDO;
        } else if (linha == matriz.length - 1 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO_INFERIOR;
        } else if (linha == matriz.length - 1 && coluna == matriz[0].length - 1) {
            return Local.CANTO_INFERIOR_DIREITO;
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
