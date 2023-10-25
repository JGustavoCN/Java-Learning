package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Jose Gustavo
 */
public class SpaceInvaders extends JPanel implements Runnable, KeyListener{
    
    private Nave nave;
    private int direcao;
    private List<Tiro> tiros;

    public SpaceInvaders() {
        nave = new Nave();
        tiros = new ArrayList<>();
        Thread lacoJogo = new Thread(this); // Importante
        lacoJogo.start();
    }
 
    @Override
    public void paintComponent(Graphics g2){
        super.paintComponent(g2); // Apaga o que foi pintado antes
        
        // AntiAliasing
        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING, 
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // nave
        nave.paint(g);
        
        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).paint(g);
        }
    }
        

    @Override
    public void run() {
        // Esquema de qualquer jogo
        while (true) { 
            update(); // atualizar o jogo
            repaint(); // repintar o jogo
            sleep(); // controlar a velociade dos outros dois
        }
    }

    
    private void update() {
        nave.update(this.getDirecao()); // trocar para update
        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).update();
            if (tiros.get(i).isDestruido()) {
                tiros.remove(i);
                i--;
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep");
            e.printStackTrace();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                this.setDirecao(Nave.TipoDirecao.DIREITA.VALOR);
                break;
            case KeyEvent.VK_A:
                this.setDirecao(Nave.TipoDirecao.ESQUERDA.VALOR);
                break;
            case KeyEvent.VK_SPACE:
                if (nave.isCarregadoTiro()){
                    this.tiros.add(this.nave.atirar());
                }
                break;
            default:
                break;
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.setDirecao(Nave.TipoDirecao.PARADO.VALOR);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.setDirecao(Nave.TipoDirecao.PARADO.VALOR);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

    
    
}
