package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Aluno
 */
public class PlanoDeFundo implements Desenhavel {

    private BufferedImage desenho;
    private int y;

    public PlanoDeFundo() {
        
        try {
            //ele consegue ler jpg , png e quais mais?
            desenho = ImageIO.read(new File("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/universo1.jpg"));
        } catch (IOException e) {
            System.out.println("Não carregou a imagem do Plano de Fundo");
            e.printStackTrace();
        }
        this.y = 0;
    }

    @Override
    public void paint(Graphics2D g) {
        // Usar o App.tela.getHeight() deixar o fundo melhor
        g.drawImage(desenho, 0, y - 768 *2, desenho.getWidth(), desenho.getHeight(), null);
        g.drawImage(desenho,0, y+300, desenho.getWidth(), desenho.getHeight(), null);
        g.drawImage(desenho,0, y, desenho.getWidth(), -desenho.getHeight(), null);
        g.drawImage(desenho,0, y, desenho.getWidth(), desenho.getHeight(), null);
        y+=2;
        if (this.y > 768*2) {
            this.y = 0;
        }
    }

}
