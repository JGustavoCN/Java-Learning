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
    private int x;
    private int y;
    private int tamanhoX;
    private int tamanhoY;

    public Chao(int x, int y, int tamanhoX, int tamanhoY) {
        this.x = x;
        this.y = y;
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        
        GRAMA.setX(x);
        GRAMA.setY(y);
        GRAMA.setTamanhoX(tamanhoX);
        GRAMA.setTamanhoY(tamanhoY);
        
        TERRA.setX(x);
        TERRA.setY(y);
        TERRA.setTamanhoX(tamanhoX);
        TERRA.setTamanhoY(tamanhoY);
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
        isCaminho = true;
    }
    
    
    
}
