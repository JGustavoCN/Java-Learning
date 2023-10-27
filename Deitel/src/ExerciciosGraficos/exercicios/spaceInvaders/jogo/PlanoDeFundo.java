package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;

/**
 *
 * @author Aluno
 */
public class PlanoDeFundo extends Desenho {
// Criar Variavel para o diretorio da imagem?
    public PlanoDeFundo() {
        super("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/universo1.jpg", "Plano de Fundo");
        this.setY(0);
        this.setVelocidade(3);
    }

    @Override
    public void paint(Graphics2D g) {
        // Fundo escalavel e que movimenta, continuar observando para erros
        g.drawImage(
                this.getDesenho(),
                0, this.getY() - App.tela.getHeight() *2,
                App.tela.getWidth(),  this.getY()+App.tela.getHeight()- App.tela.getHeight() *2,
                0,0 , 
                this.getDesenho().getWidth(), this.getDesenho().getHeight(), 
                null);
        
        g.drawImage(
                this.getDesenho(),
                0, this.getY(),
                App.tela.getWidth(),  -App.tela.getHeight()+this.getY(),
                0, 0, 
                this.getDesenho().getWidth(), this.getDesenho().getHeight(),
                null);
        
        g.drawImage(
                this.getDesenho(),
                0, this.getY(),
                App.tela.getWidth(),  this.getY()+App.tela.getHeight(),
                0, 0, 
                this.getDesenho().getWidth(), this.getDesenho().getHeight(), 
                null);
        
        
        this.setY(this.getY()+this.getVelocidade());
        if (this.getY() > App.tela.getHeight()*2) {
            this.setY(0);
        }
    }

    @Override
    public void update() {
        
    }
 
}
