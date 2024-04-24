package ExerciciosGraficos.exercicios.tetris.main;

import ExerciciosGraficos.exercicios.tetris.mino.*;
import ExerciciosGraficos.exercicios.tetris.mino.minos.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author José Gustavo
 */
public class PlayManager {

    //Main paly Area
    final int LARGURA = 360;
    final int ALTURA = 600;
    public static int esquerda_x;
    public static int direita_x;
    public static int cima_y;
    public static int baixo_y;

    //Minos
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;
    Mino nextMino;
    final int NEXTMINO_START_X;
    final int NEXTMINO_START_Y;
    public static List<Block> staticBlocks = new ArrayList<>();

    // Outros
    public static int dropInterval = 60;
    boolean gameOver;

    // Efeitos
    boolean effectCounterOn;
    int effectCounter;
    List<Integer> effectY = new ArrayList<>();

    // Score
    int level = 1;
    int lines;
    int score;
    
    public PlayManager() {
        //Main Play Area Frame
        esquerda_x = (GamePanel.LARGURA / 2) - (LARGURA / 2);
        direita_x = esquerda_x + LARGURA;
        cima_y = 50;
        baixo_y = cima_y + ALTURA;
        
        MINO_START_X = esquerda_x + (LARGURA / 2) - Block.SIZE;
        MINO_START_Y = cima_y + Block.SIZE;
        
        NEXTMINO_START_X = direita_x + 175;
        NEXTMINO_START_Y = cima_y + 500;
        
        currentMino = pickMino();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
        
        nextMino = pickMino();
        nextMino.setXY(NEXTMINO_START_X, NEXTMINO_START_Y);
    }
    
    private Mino pickMino() {
        Mino mino = null;
        int i = new Random().nextInt(7);
        switch (i) {
            case 0:
                mino = new Mino_L1();
                break;
            case 1:
                mino = new Mino_L2();
                break;
            case 2:
                mino = new Mino_Square();
                break;
            case 3:
                mino = new Mino_Bar();
                break;
            case 4:
                mino = new Mino_T();
                break;
            case 5:
                mino = new Mino_Z1();
                break;
            case 6:
                mino = new Mino_Z2();
                break;
        }
        return mino;
    }
    
    public void update() {
        if (currentMino.active == false) {
            // se currentMino estiver desativado, vai colocar ele nos blocos estatico
            staticBlocks.add(currentMino.b[0]);
            staticBlocks.add(currentMino.b[1]);
            staticBlocks.add(currentMino.b[2]);
            staticBlocks.add(currentMino.b[3]);
            
            if (currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y) {
                gameOver = true;
                GamePanel.music.stop();
                GamePanel.se.playMusic(2, false);
            }
            
            currentMino.deactivating = false;

            // trocando os Minos
            if (!gameOver) {
                currentMino = nextMino;
                currentMino.setXY(MINO_START_X, MINO_START_Y);
                nextMino = pickMino();
                nextMino.setXY(NEXTMINO_START_X, NEXTMINO_START_Y);
                cheackDelete();
            }
            
            
        } else {
            currentMino.update();
        }
        
    }
    
    private void cheackDelete() {
        
        int x = esquerda_x;
        int y = cima_y;
        int blockCount = 0;
        
        int linesCounter = 0;
        
        while (x < direita_x && y < baixo_y) {
            
            for (Block staticBlock : staticBlocks) {
                if (staticBlock.x == x && staticBlock.y == y) {
                    blockCount++;
                }
            }
            
            x += Block.SIZE;
            
            if (x == direita_x) {
                
                if (blockCount == 12) {

                    // precisa ser uma lista, devido a quantidade indefinida de linhas que podem ser excluidas
                    effectCounterOn = true;
                    effectY.add(y);

                    // delete line
                    for (int i = staticBlocks.size() - 1; i > -1; i--) {
                        if (staticBlocks.get(i).y == y) {
                            staticBlocks.remove(i);
                        }
                    }

                    // counter
                    linesCounter++;
                    lines++;
                    
                    if (lines % 10 == 0 && dropInterval > 1) {
                        
                        level++;
                        if (dropInterval > 10) {
                            dropInterval -= 10;
                        } else {
                            dropInterval -= 1;
                        }
                        
                    }
                    
                    for (Block staticBlock : staticBlocks) {
                        if (staticBlock.y < y) {
                            staticBlock.y += Block.SIZE;
                        }
                    }
                }
                
                blockCount = 0;
                x = esquerda_x;
                y += Block.SIZE;
            }
            
        }

        // add score
        if (linesCounter > 0) {
            GamePanel.se.playMusic(1, false);
            int singleLineScore = 10 * level;
            score += singleLineScore * linesCounter;
        }
        
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

        //paint score frame
        g2.drawRect(x, cima_y, 250, 300);
        x += 40;
        y = cima_y + 90;
        g2.drawString("LEVEL: " + level, x, y);
        y += 70;
        g2.drawString("LINES: " + lines, x, y);
        y += 70;
        g2.drawString("SCORE: " + score, x, y);

        //Paint curremtMino
        if (currentMino != null) {
            currentMino.paint(g2);
        }
        // paint NextMino
        nextMino.paint(g2);

        // paint static blocks
        for (Block staticBlock : staticBlocks) {
            staticBlock.paint(g2);
        }

        // paint effect
        if (effectCounterOn) {
            effectCounter++;
            g2.setColor(Color.WHITE);
            for (Integer effect : effectY) {
                g2.fillRect(esquerda_x, effect, LARGURA, Block.SIZE);
            }
            // time effect
            if (effectCounter == 10) {
                effectCounterOn = false;
                effectCounter = 0;
                effectY.clear();
            }
            
        }
 
        // paint pause
        g2.setColor(Color.YELLOW);
        g2.setFont(g2.getFont().deriveFont(50f));
        if (gameOver) {
            x = esquerda_x + 25;
            y = cima_y + 320;
            g2.drawString("GAME OVER", x, y);
        } else if (KeyHandler.pausePressed) {
            x = esquerda_x + 95;
            y = cima_y + 329;
            g2.drawString("PAUSE", x, y);
        }
        x = 65;
        y = cima_y + 320;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Times New Roman", Font.ITALIC, 60));
        g2.drawString("Simple Tetris", x, y);
        
    }
}
