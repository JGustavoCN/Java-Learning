package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class Tiro extends Desenho {
    
    public Tiro(int inicioX, int inicioY){
//super("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/tiro.png", "Tiro");
        this.setX(inicioX);
        this.setY(inicioY);
        this.setVelocidade(6);
        this.setTamanhoX(3);
        this.setTamanhoY(15);
      
    }
    
    @Override
    public void paint(Graphics2D g) {
        
/*Tentar entender melhor
        g.drawImage(this.getDesenho(), 
                this.getX()+100, this.getY(),this.getX(), this.getY()-150,
                0, 0, this.getY()+this.getDesenho().getWidth(), this.getY()+this.getDesenho().getHeight(), null);
*/
        g.setColor(Color.red);
        g.fillRect(this.getX(), this.getY(), this.getTamanhoX(), this.getTamanhoY());
    }
    
    @Override
    public void update(){
        this.setY(this.getY() - this.getVelocidade());
    }
    
    // Posso juntar???
    public boolean colideCom(Inimigo inimigo) {
        
        if (this.getX() >= inimigo.getX() && this.getX() + this.getTamanhoX() <= inimigo.getX() + inimigo.getTamanhoX()) {
            if (this.getY() <= inimigo.getY() + inimigo.getTamanhoY()) {
                return true;
            }
        }
        
        return false;

    }
// Posso juntar???
    boolean isDestruido() {
        return this.getY() < 0;
    }
    
}
