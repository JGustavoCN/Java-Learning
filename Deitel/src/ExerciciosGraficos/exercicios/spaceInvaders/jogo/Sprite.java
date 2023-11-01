package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.image.BufferedImage;

/**
 *
 * @author José Gustavo
 */
//Sprite uma animacao para por exemplo minha explosao
public abstract class Sprite extends Desenho {

    private int duracao;
    private int animacaoTotal;
    private int linha;
    private int coluna;
    private int tamanhoSpriteX;
    private int tamanhoSpriteY;

    public Sprite(BufferedImage desenho, int x, int y) {
        super(desenho, x, y);

    }

    /**
     *
     * @param desenho
     * @param x
     * @param y
     * @param animacaoTotal Quantidade de Colunas * Quantidade de Linhas que tem
     * o sprite
     * @param tamanhoSpriteX dividir a imagem pela quantidade de colunas entre
     * cada parte do desenho
     * @param tamanhoSpriteY dividir a imagem pela quantidade de linhas entre
     * cada parte do desenho
     */
    public Sprite(BufferedImage desenho, int x, int y, int animacaoTotal, int tamanhoSpriteX, int tamanhoSpriteY) {

        super(desenho, x, y);
        this.animacaoTotal = animacaoTotal;
        this.tamanhoSpriteX = tamanhoSpriteX;
        this.tamanhoSpriteY = tamanhoSpriteY;

    }

    public final boolean acabou() {
        return duracao >= animacaoTotal;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnimacaoTotal() {
        return animacaoTotal;
    }

    public void setAnimacaoTotal(int animacaoTotal) {
        this.animacaoTotal = animacaoTotal;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getTamanhoSpriteX() {
        return tamanhoSpriteX;
    }

    public void setTamanhoSpriteX(int tamanhoSpriteX) {
        this.tamanhoSpriteX = tamanhoSpriteX;
    }

    public int getTamanhoSpriteY() {
        return tamanhoSpriteY;
    }

    public void setTamanhoSpriteY(int tamanhoSpriteY) {
        this.tamanhoSpriteY = tamanhoSpriteY;
    }

}
