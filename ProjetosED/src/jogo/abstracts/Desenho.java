package jogo.abstracts;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author José Gustavo
 */
public abstract class Desenho implements Desenhavel{

    private BufferedImage desenho;
    private String nome;
    public Formato formato;

    public Desenho(String localizacaoDaImagem, String nome) {
        
        try {
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
        formato.x = x;
        formato.y = y;
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
                formato.x, formato.y, 
                    formato.x + formato.tamanhoX, formato.y + formato.tamanhoY,
                0, 0,
                this.getDesenho().getWidth(), this.getDesenho().getHeight(),
                null);
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

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
   
}
