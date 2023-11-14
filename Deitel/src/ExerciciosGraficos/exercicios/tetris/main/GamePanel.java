package ExerciciosGraficos.exercicios.tetris.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author José Gustavo
 */
public class GamePanel extends JPanel implements Runnable {

    public static final int LARGURA = 1280;
    public static final int ALTURA = 720;
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;

    public GamePanel() {
        //Configuração
        this.setPreferredSize(new Dimension(LARGURA, ALTURA));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        
        // KeyListener
        this.addKeyListener(new KeyHandler());
        // O que faz esse metodo???
        this.setFocusable(true);
        pm = new PlayManager();
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1_000_000_000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (gameThread!= null) {           
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            // PQ??????
            lastTime = currentTime;
            if (delta >= 1) {
                
                update();
                repaint();
                delta--;
            }
        }
   
    }

    
    public void update() {
        if (KeyHandler.pausePressed == false && pm.gameOver == false) {
           pm.update(); 
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pm.paint(g2);
    }
    
}
