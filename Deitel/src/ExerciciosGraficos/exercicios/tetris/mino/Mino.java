package ExerciciosGraficos.exercicios.tetris.mino;

import ExerciciosGraficos.exercicios.tetris.main.KeyHandler;
import ExerciciosGraficos.exercicios.tetris.main.PlayManager;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class Mino {

    public Block b[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;
    public int direcao = 1; // Quatro direcoes 1234

    public void create(Color c) {
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }

    public void setXY(int x, int y) {}

    public void updateXY(int direcao) {
        this.direcao = direcao;
        b[0].x = tempB[0].x;
        b[0].y = tempB[0].y;
        b[1].x = tempB[1].x;
        b[1].y = tempB[1].y;
        b[2].x = tempB[2].x;
        b[2].y = tempB[2].y;
        b[3].x = tempB[3].x;
        b[3].y = tempB[3].y;
    }

    public void getDirecao1(){};
    public void getDirecao2(){};
    public void getDirecao3(){};
    public void getDirecao4(){};

    public void update() {
        
        // Move
        if (KeyHandler.upPressed) {
            switch (direcao) {
                case 1:
                    getDirecao2();
                    break;
                case 2:
                    getDirecao3();
                    break;
                case 3:
                    getDirecao4();
                    break;
                case 4:
                    getDirecao1();
                    break;
               
                   
            }
            KeyHandler.upPressed = false;
        }
        if (KeyHandler.downPressed) {
            b[0].y += Block.SIZE;
            b[1].y += Block.SIZE;
            b[2].y += Block.SIZE;
            b[3].y += Block.SIZE;
            autoDropCounter = 0;
            KeyHandler.downPressed = false;
        }
        if (KeyHandler.leftPressed) {
            b[0].x -= Block.SIZE;
            b[1].x -= Block.SIZE;
            b[2].x -= Block.SIZE;
            b[3].x -= Block.SIZE;
          
            KeyHandler.leftPressed = false;
        }
        if (KeyHandler.rightPressed) {
            b[0].x += Block.SIZE;
            b[1].x += Block.SIZE;
            b[2].x += Block.SIZE;
            b[3].x += Block.SIZE;

            KeyHandler.rightPressed = false;
        }
        
        autoDropCounter++;
        if (autoDropCounter == PlayManager.dropInterval) {
            b[0].y += Block.SIZE;
            b[1].y += Block.SIZE;
            b[2].y += Block.SIZE;
            b[3].y += Block.SIZE;
            autoDropCounter = 0;
        }
    }

    public void paint(Graphics2D g2) {
        int margem = 2;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x + margem, b[0].y + margem, Block.SIZE - (margem * 2), Block.SIZE - (margem * 2));
        g2.fillRect(b[1].x + margem, b[1].y + margem, Block.SIZE - (margem * 2), Block.SIZE - (margem * 2));
        g2.fillRect(b[2].x + margem, b[2].y + margem, Block.SIZE - (margem * 2), Block.SIZE - (margem * 2));
        g2.fillRect(b[3].x + margem, b[3].y + margem, Block.SIZE - (margem * 2), Block.SIZE - (margem * 2));

    }
}
