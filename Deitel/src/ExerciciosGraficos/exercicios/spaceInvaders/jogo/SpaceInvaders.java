package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Jose Gustavo
 */
public class SpaceInvaders extends JPanel implements Runnable, KeyListener{
    
    private Font fonte = new Font("Consolas",Font.BOLD,20);
    private Nave nave;
    private int direcao;
    private List<Tiro> tiros;
    private List<Inimigo> inimigos;
    private PlanoDeFundo local;
    private boolean ganhou;

    public SpaceInvaders() {
        ganhou = false;
        local = new PlanoDeFundo();
        nave = new Nave();
        tiros = new ArrayList<>();
        inimigos = new ArrayList<>();
        BufferedImage desenhoInimigos = null;
        try {
            desenhoInimigos = ImageIO.read(new File("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/inimigo.png"));
        } catch (IOException e) {
            System.out.println("Não carregou a imagem do inimigo");
            e.printStackTrace();
        }
        
        for (int i = 0; i < 60; i++) {
            
            inimigos.add(new Inimigo(desenhoInimigos,50 + i%20 * 60, 50 + i/20 * 50,1));
           
        }
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
        
        // local
        local.paint(g);
        // nave
        nave.paint(g);
        
        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).paint(g);
        }
        // inimigos
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).paint(g);
        }
        if (ganhou) {
            g.setColor(Color.white);
            g.setFont(fonte);
            g.drawString("VOCÊ TERMINOU O JOGO!!!", App.tela.getWidth()/2 - 150, App.tela.getHeight()/2);
        }
    }
        

    @Override
    public void run() {
        // Esquema de qualquer jogo
        while (true) { 
            long tempoInicial = System.currentTimeMillis();
            update(); // atualizar o jogo
            repaint(); // repintar o jogo
            
            long tempoFinal = System.currentTimeMillis();
            long duracao = 16 - (tempoFinal -tempoInicial);
            if (duracao > 0) {
                sleep(duracao); // controlar a velociade dos outros dois
            }
            
            
        }
    }

    
    private void update() {
        if (inimigos.size() == 0) {
            ganhou = true;
        }
        nave.update(this.getDirecao());
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).update();
            
        }
        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).update();
            if (tiros.get(i).isDestruido()) {
                tiros.remove(i);
                i--;
            } else {
                for (int j = 0; j < inimigos.size(); j++) {
                    if (tiros.get(i).colideCom(inimigos.get(j))) {
                        inimigos.remove(j);
                        j--;
                        tiros.remove(i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < inimigos.size(); i++) {
            if (inimigos.get(i).getX() <= 0 || inimigos.get(i).getX() >= App.tela.getWidth()-50) {
                for (int j = 0; j < inimigos.size(); j++) {
                    inimigos.get(j).trocarDirecao();
                    
                }
                break;
            }
            
        }
        
    }

    private void sleep(long duracao) {
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep");
            e.printStackTrace();
        }
    }
 ///======== A nave passa da tela
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                this.setDirecao(Nave.TipoDirecao.PARADO.VALOR);
                break;
            case KeyEvent.VK_A:
                this.setDirecao(Nave.TipoDirecao.PARADO.VALOR);
                break;
            default:
                break;
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
