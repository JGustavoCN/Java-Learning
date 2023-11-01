package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class Nave extends Desenho{
    
    private int carregarTiro;
    private boolean carregadoTiro;

    public Nave(){
        super("src/ExerciciosGraficos/exercicios/spaceInvaders/imagens/nave.png","Nave");
        this.setX(App.tela.getWidth()/2 -100);
        this.setVelocidade(5);
        carregadoTiro = true;
        carregarTiro = 3;
    }
    
    @Override
    public void paint(Graphics2D g){
        // Desenhando a imagem e modificando o tamanho
        g.drawImage(
                this.getDesenho(), 
                this.getX(), App.tela.getHeight() - 150, this.getX()+100, App.tela.getHeight() - 150+100,
                0,0,
                this.getDesenho().getWidth(), this.getDesenho().getHeight(), 
                null);
    }

    public Tiro atirar() {
        this.carregadoTiro = false;
        this.carregarTiro = 0;
        Tiro tiro = new Tiro(this.getX()+48, App.tela.getHeight() - 150);
        return tiro;
        
    }

    @Override
    public void update() {
        
    }
    
    
    // Modificar a direcao do do space invadres e trazer para ca
    enum TipoDirecao{
        DIREITA(1),ESQUERDA(-1), PARADO(0);
        
        public final int VALOR;
        
        private TipoDirecao(int valor){
            this.VALOR = valor;
        }
        
    }
    // modificar
    public void movimentar(int direcao) {
        if (direcao == TipoDirecao.DIREITA.VALOR) {
            this.setX(this.getX()+this.getVelocidade());
        } else if (direcao == TipoDirecao.ESQUERDA.VALOR) {
            this.setX(this.getX()-this.getVelocidade());
        }
        if (carregarTiro >= 15) {
            this.setCarregadoTiro(true);
            this.setCarregarTiro(0);
        }
        this.setCarregarTiro(this.getCarregarTiro() + 1);
        
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
