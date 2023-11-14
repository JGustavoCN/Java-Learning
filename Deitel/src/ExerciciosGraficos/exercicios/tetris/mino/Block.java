package ExerciciosGraficos.exercicios.tetris.mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author José Gustavo
 */
public class Block extends Rectangle{
    public int x,y;
    public static final int SIZE = 30;
    public Color c;

    public Block(Color c) {
        this.c = c;
    }
     public void paint(Graphics2D g2) {
         // Posso remover a margem fica bonito
         int margem = 2;
         g2.setColor(c);
         g2.fillRect(x+margem, y+margem, SIZE-(margem*2), SIZE-(margem*2));
     }
}
