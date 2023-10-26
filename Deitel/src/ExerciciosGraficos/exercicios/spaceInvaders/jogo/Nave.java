package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author José Gustavo
 */
public class Nave implements Desenhavel{
    
    private BufferedImage desenho;
    private int x;
    private int velocidade;
    private int carregarTiro;
    private boolean carregadoTiro;
    
    public Nave(){
        try {
            desenho = ImageIO.read(new File("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/nave.png"));
        } catch (IOException e) {
            System.out.println("Não carregou a imagem da nave");
            e.printStackTrace();
        }
        x = App.tela.getWidth()/2 -100;
        velocidade = 5;
        carregadoTiro = true;
        carregarTiro = 3;
    }
    
    @Override
    public void paint(Graphics2D g){
        // Desenhando a imagem e modificando o tamanho
        g.drawImage(
                desenho, 
                this.getX(), App.tela.getHeight() - 150, this.getX()+100, App.tela.getHeight() - 150+100,
                0,0,
                desenho.getWidth(), desenho.getHeight(), 
                null);
    }

    public Tiro atirar() {
        this.carregadoTiro = false;
        this.carregarTiro = 0;
        Tiro tiro = new Tiro(this.getX() + 48, App.tela.getHeight() - 150);
        return tiro;
        
    }
    
    enum TipoDirecao{
        DIREITA(1),ESQUERDA(-1), PARADO(0);
        
        public final int VALOR;
        
        private TipoDirecao(int valor){
            this.VALOR = valor;
        }
        
    }
    
    public void update(int direcao) {
        if (direcao == TipoDirecao.DIREITA.VALOR) {
            this.setX(this.getX()+this.getVelocidade());
        } else if (direcao == TipoDirecao.ESQUERDA.VALOR) {
            this.setX(this.getX()-this.getVelocidade());
        }
        if (carregarTiro >= 10) {
            this.setCarregadoTiro(true);
            this.setCarregarTiro(0);
        }
        this.setCarregarTiro(this.getCarregarTiro() + 1);
        
    }
    
    public BufferedImage getDesenho() {
        return desenho;
    }

    public void setDesenho(BufferedImage desenho) {
        this.desenho = desenho;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getCarregarTiro() {
        return carregarTiro;
    }

    public void setCarregarTiro(int carregarTiro) {
        this.carregarTiro = carregarTiro;
    }

    public boolean isCarregadoTiro() {
        return carregadoTiro;
    }

    public void setCarregadoTiro(boolean carregadoTiro) {
        this.carregadoTiro = carregadoTiro;
    }
    
}
