package ExerciciosGraficos.exercicios.tetris.main;

import ExerciciosGraficos.exercicios.tetris.mino.Block;
import ExerciciosGraficos.exercicios.tetris.mino.Mino;
import ExerciciosGraficos.exercicios.tetris.mino.minos.Mino_L1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author José Gustavo
 */
public class PlayManager {

    final int LARGURA = 360;
    final int ALTURA = 600;
    public static int esquerda_x;
    public static int direita_x;
    public static int cima_y;
    public static int baixo_y;

    public static int dropInterval = 60;

    //Mino
    Mino currentMino;

    final int MINO_START_X;
    final int MINO_START_Y;

    public PlayManager() {
        //Main Play Area Frame
        esquerda_x = (GamePanel.LARGURA / 2) - (LARGURA / 2);
        direita_x = esquerda_x + LARGURA;
        cima_y = 50;
        baixo_y = cima_y + ALTURA;

        MINO_START_X = esquerda_x + (LARGURA / 2) - Block.SIZE;
        MINO_START_Y = cima_y + Block.SIZE;
        currentMino = new Mino_L1();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }

    public void update() {
        currentMino.update();
    }

    public void paint(Graphics2D g2) {

        //Play Area
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(esquerda_x - 4, cima_y - 4, LARGURA + 8, ALTURA + 8);

        //Next Mino
        int x = direita_x + 100;
        int y = baixo_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y + 60);

        //Paint curremtMino
        if (currentMino != null) {
            currentMino.paint(g2);
        }

    }
}
