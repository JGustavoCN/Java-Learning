package jogo;

import java.awt.Graphics2D;

/**
 *
 * @author José Gustavo
 */
public class Chao implements Desenhavel, Atualizavel{

    private static final String LOCALIZACAO_IMAGEM_GRAMA = "src/jogo/imagens/grama.jpg";
    private static final String LOCALIZACAO_IMAGEM_TERRA = "src/jogo/imagens/terra.jpg";
    
    private final Desenho GRAMA = new Desenho(LOCALIZACAO_IMAGEM_GRAMA, "Grama");
    private final Desenho TERRA = new Desenho(LOCALIZACAO_IMAGEM_TERRA, "Terra");
    
    private boolean isCaminho;
   
    public Chao(int x , int y) {
        int tamanho = 100;
        
        GRAMA.setX(x);
        GRAMA.setY(y);
        GRAMA.setTamanhoX(tamanho);
        GRAMA.setTamanhoY(tamanho);
        
        TERRA.setX(x);
        TERRA.setY(y);
        TERRA.setTamanhoX(tamanho);
        TERRA.setTamanhoY(tamanho);
        
    }

    @Override
    public void paint(Graphics2D g) {
        if (isCaminho) {
            TERRA.paint(g);
        }else{
            GRAMA.paint(g);
        }
        
    }

    @Override
    public void update() {
        java.util.Random random = new java.util.Random();
        if (random.nextInt(10) == 5) {
            isCaminho = !isCaminho;
        }
    }
    
    
    
}
