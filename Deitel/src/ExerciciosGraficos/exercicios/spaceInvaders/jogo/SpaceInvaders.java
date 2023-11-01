package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose Gustavo
 */
// Ele é um desenho? 
// Melhorar
public class SpaceInvaders extends Jogo {

    private Font fonte = new Font("Consolas", Font.BOLD, 20);
    private Nave nave;
    private int direcao;
    private List<Tiro> tiros;
    private List<Inimigo> inimigos;
    private List<Explosao> explosoes;
    private PlanoDeFundo local;
    private boolean ganhou;
    private boolean perdeu;
    // modificar
    // Inimigo deve controlar a explosoes
    private BufferedImage desenhoExplosao;

    public SpaceInvaders() {
        ganhou = false;
        local = new PlanoDeFundo();
        nave = new Nave();
        tiros = new ArrayList<>();
        inimigos = new ArrayList<>();
        explosoes = new ArrayList<>();

        // modificar
        BufferedImage desenhoInimigos = null;

        try {
            desenhoInimigos = ImageIO.read(new File("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/inimigo.png"));
            desenhoExplosao = ImageIO.read(new File("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/explosoes.png"));
        } catch (IOException e) {
            System.out.println("Não carregou a imagem do inimigo");
            e.printStackTrace();
        }

        for (int i = 0; i < 60; i++) {
            inimigos.add(new Inimigo(desenhoInimigos, 50 + i % 20 * 70, 50 + i / 20 * 75, 1));
        }
        Thread lacoJogo = new Thread(this); // Importante
        lacoJogo.start();
    }

    @Override
    public void paint(Graphics2D g) {
        // local
        local.paint(g);

        for (int i = 0; i < explosoes.size(); i++) {
            explosoes.get(i).paint(g);
        }
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
            g.drawString("VOCÊ TERMINOU O JOGO!!!", App.tela.getWidth() / 2 - 150, App.tela.getHeight() / 2);
        }
        if (perdeu) {
            g.setColor(Color.white);
            g.setFont(fonte);
            g.drawString("OS INIMIGOS GANHARAM!!!", App.tela.getWidth() / 2 - 150, App.tela.getHeight() / 2);
        }
    }

    @Override
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        Graphics2D g = this.ativarAntiAliasing(g2);
        this.paint(g);
    }

    @Override
    public void run() {
        // Esquema de qualquer jogo
        while (true) {
            
            long tempoInicial = System.currentTimeMillis();
            update(); // atualizar o jogo
            repaint(); // repintar o jogo
            long tempoFinal = System.currentTimeMillis();
            
            long duracao = 16 - (tempoFinal - tempoInicial);
            if (duracao > 0) {
                sleep(duracao); // controlar a velociade dos outros dois
            }

        }
    }

    @Override
    public void update() {
        if (inimigos.isEmpty()) {
            ganhou = true;
        }
        nave.movimentar(this.getDirecao());
        for (int i = 0; i < explosoes.size(); i++) {
            explosoes.get(i).update();

            if (explosoes.get(i).acabou()) {
                explosoes.remove(i);
            }
        }

        for (int i = 0; i < tiros.size(); i++) {
            tiros.get(i).update();
            if (tiros.get(i).isDestruido()) {
                tiros.remove(i);
                i--;
            } else {
                for (int j = 0; j < inimigos.size(); j++) {
                    if (tiros.get(i).colideCom(inimigos.get(j))) {
                        explosoes.add(new Explosao(
                                desenhoExplosao, 
                                inimigos.get(j).getX(), inimigos.get(j).getY(),
                                25,130,130));
                        inimigos.remove(j);
                        j--;
                        tiros.remove(i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).update();
            if (inimigos.get(i).getY() >= App.tela.getHeight() - 150) {
                perdeu = true;
            }

        }
        for (int i = 0; i < inimigos.size(); i++) {
            if (inimigos.get(i).getX() <= 0 || inimigos.get(i).getX() >= App.tela.getWidth() - 50) {
                for (int j = 0; j < inimigos.size(); j++) {
                    inimigos.get(j).trocarDirecao();

                }
                break;
            }

        }

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
    ///======== A nave passa da tela

    @Override
    public void keyPressed(KeyEvent e) {
//      VK é uma abreviação para Virtual Key
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_D:
                this.setDirecao(Nave.TipoDirecao.DIREITA.VALOR);
                break;
            case KeyEvent.VK_A:

                this.setDirecao(Nave.TipoDirecao.ESQUERDA.VALOR);
                break;
            case KeyEvent.VK_SPACE:
                if (nave.isCarregadoTiro()) {
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
//Esta passando da tela
        if (this.nave.getX() >= 0 && this.nave.getX() <= App.tela.getWidth()) {

        }
        this.direcao = direcao;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

}
