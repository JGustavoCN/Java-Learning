package jogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class GamePanel extends Jogo {

    public static final int LARGURA = 500;
    public static final int ALTURA = 500;
    private final int FPS = 60;
    private Thread gameThread;
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

    @Override
    public void sleep(long duracao) {
        try {
            Thread.sleep(duracao);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep");
            e.printStackTrace();
        }
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            // PQ??????
            lastTime = currentTime;
            if (delta >= 1) {
                long tempoInicial = System.currentTimeMillis();
                update(); // atualizar o jogo
                repaint(); // repintar o jogo
                long tempoFinal = System.currentTimeMillis();

                long duracao = 16 - (tempoFinal - tempoInicial);
                if (duracao > 0) {
                    sleep(duracao); // controlar a velociade dos outros dois
                }
                delta--;
            }
        }
    }

    @Override
    public void update() {
        pm.update();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = pm.ativarAntiAliasing(g);
        pm.paint(g2);
        g2.dispose();
    }

}
