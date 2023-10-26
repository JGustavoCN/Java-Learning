package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author José Gustavo
 */
public class Inimigo implements Desenhavel{

    private BufferedImage desenho;
    private int x;
    private int y;
    private int direcao;
    private int velocidade;
    private int tamanho;
    

    
    // usar enum na direcao
    public Inimigo(BufferedImage desenho,int inicioX, int inicioY, int direcao) {
        
        this.desenho = desenho;
        this.x = inicioX;
        this.y = inicioY;
        this.direcao = direcao;
        this.velocidade = 3;
        this.tamanho = 50;
       
    }
    
    @Override
    public void paint(Graphics2D g) {
        
        g.drawImage(
                desenho, 
                x, y,x+ tamanho, y+tamanho,
                0,0,desenho.getWidth(), desenho.getHeight(), 
                null);
    }
    
    public void update(){
        this.x += this.velocidade * this.direcao;
    }
    public void trocarDirecao(){
        this.direcao = this.direcao * -1;
        this.y += 15;
    }

    public BufferedImage getDesenho() {
        return desenho;
    }

    public void setDesenho(BufferedImage desenho) {
        this.desenho = desenho;
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

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
}
