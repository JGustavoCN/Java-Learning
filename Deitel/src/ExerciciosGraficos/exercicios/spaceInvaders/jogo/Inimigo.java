package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author José Gustavo
 */
public class Inimigo extends Desenho {

    private int direcao;

    // usar enum na direcao
    public Inimigo(BufferedImage desenho, int inicioX, int inicioY, int direcao) {
        super(desenho,inicioX,inicioY);
        this.direcao = direcao;
        this.setVelocidade(3);
        this.setTamanhoX(50);
        this.setTamanhoY(50);

    }

    @Override
    public void paint(Graphics2D g) {

        g.drawImage(
                this.getDesenho(),
                this.getX(), this.getY(), 
                    this.getX() + this.getTamanhoX(), this.getY() + this.getTamanhoY(),
                0, 0,
                this.getDesenho().getWidth(), this.getDesenho().getHeight(),
                null);
    }

    @Override
    public void update() {
        this.setX(this.getX()+this.getVelocidade() * this.direcao);
    }

    public void trocarDirecao() {
        this.direcao = this.direcao * -1;
        this.setY(this.getY()+ 15);
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

}
