package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author José Gustavo
 */
public class Explosao extends Sprite {

//    Passar o desenho que vai ser explodido?
    public Explosao(BufferedImage desenho, int x, int y, int animacaoTotal, int tamanhoSpriteX, int tamanhoSpriteY) {
        super(desenho, x, y, animacaoTotal, tamanhoSpriteX, tamanhoSpriteY);
        this.setVelocidade(1);
    }

    @Override
    public void paint(Graphics2D g) {
        int tamanhoExplosao = 50;
        g.drawImage(
                this.getDesenho(),
                this.getX(), this.getY(),
                this.getX() + tamanhoExplosao, this.getY() + tamanhoExplosao,
                this.getColuna(), this.getLinha(),
                this.getColuna() + this.getTamanhoSpriteX(), this.getLinha() + this.getTamanhoSpriteY(),
                null);
    }

    // Modificar não esta explodindo todas
    @Override
    public void update() {
        int quantidadeColunas = 5;
        int quantidadeLinhas = 5;
        this.setLinha((this.getDuracao() / quantidadeLinhas) * this.getTamanhoSpriteY());
        this.setColuna((this.getDuracao() % quantidadeColunas) * this.getTamanhoSpriteX());
        this.setDuracao(this.getDuracao() + this.getVelocidade());
    }

}
