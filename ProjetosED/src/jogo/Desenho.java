package jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author José Gustavo
 */
public class Desenho implements Desenhavel, Atualizavel{

    private BufferedImage desenho;
    private String nome;
    private int x;
    private int y;
    private int tamanhoX;
    private int tamanhoY;
    

    public Desenho(String localizacaoDaImagem, String nome) {
        
        try {
            System.out.println(localizacaoDaImagem);
            this.desenho = ImageIO.read(new File(localizacaoDaImagem));
        } catch (IOException e) {
            System.out.println("Não carregou a imagem do/a " + nome);
            e.printStackTrace();
        } finally {
            this.nome = nome;
        }
        
    }
    
    public Desenho(BufferedImage desenho, int x, int y) {
        this.desenho = desenho;
        this.x = x;
        this.y = y;
    }
    
    public Desenho(BufferedImage desenho) {
        this.desenho = desenho;
        
    }
    public Desenho() {
        
    }
    
    @Override
    public void paint(Graphics2D g) {
        g.drawImage(
                this.getDesenho(),
                this.getX(), this.getY(), 
                    this.getX() + this.getTamanhoX(), this.getY() + this.getTamanhoY(),
                0, 0,
                this.getDesenho().getWidth(), this.getDesenho().getHeight(),
                null);
    }

    @Override
    public void update() {

    }

    public BufferedImage getDesenho() {
        return desenho;
    }
// carregar imagem no set? criar outro metodo para isso? Dar a posibilidade de trocar a imagem?
    public void setDesenho(BufferedImage desenho) {
        this.desenho = desenho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTamanhoX() {
        return tamanhoX;
    }

    public void setTamanhoX(int tamanhoX) {
        this.tamanhoX = tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public void setTamanhoY(int tamanhoY) {
        this.tamanhoY = tamanhoY;
    }

   
}
