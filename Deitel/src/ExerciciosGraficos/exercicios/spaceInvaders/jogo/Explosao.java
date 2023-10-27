package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author José Gustavo
 */

//Melhorar

public class Explosao extends Desenho{

    private int duracao;
    private int animacaoTotal;
    private int linha;
    private int coluna;
    
    public Explosao(BufferedImage desenho, int x, int y) {
        super(desenho, x, y);
        this.animacaoTotal= 25;
        this.duracao = 0;
        this.linha = 0;
        this.coluna = 0;
        
    } 
    
    @Override
    public void paint(Graphics2D g) {
        int tamannho = 192;
        g.drawImage(
                this.getDesenho(), 
                this.getX(), this.getY(), 
                this.getX() + 50, this.getY() + 50, 
                tamannho * coluna, tamannho* linha,
                tamannho * coluna + tamannho, tamannho * linha + tamannho,
                null);
    }

 // Modificar não esta explodindo todas
    @Override
    public void update() {
        this.duracao++;
        linha = duracao/6;
        coluna = duracao%5;
    }

    public boolean acabou(){
        return duracao >= animacaoTotal;
    }
    
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
}
