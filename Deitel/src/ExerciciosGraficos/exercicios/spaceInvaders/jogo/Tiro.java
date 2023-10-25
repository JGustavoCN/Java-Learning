package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class Tiro implements Desenhavel{

    private int x;
    private int y;
    private int velocidade;
    
    public Tiro(int inicioX, int inicioY){
        this.x = inicioX;
        this.y = inicioY;
        this.velocidade = 6;
    }
    
    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 3, 15);
    }
    
    public void update(){
        this.setY(this.getY() - this.getVelocidade());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    boolean isDestruido() {
        return this.getY() < 0;
    }
    
}
