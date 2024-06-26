package jogo.models;

import java.awt.Graphics2D;
import jogo.abstracts.Atualizavel;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Desenho;
import jogo.abstracts.Formato;

/**
 *
 * @author José Gustavo
 */
public class Chao implements Desenhavel, Atualizavel {

    public static class Grama extends Desenho {

        private static final String LOCALIZACAO_IMAGEM = "src/jogo/imagens/grama.jpg";

        public Grama() {
            super(LOCALIZACAO_IMAGEM, "Grama");
        }
    }

    public static class Terra extends Desenho {

        private static final String LOCALIZACAO_IMAGEM = "src/jogo/imagens/terra.jpg";

        public Terra() {
            super(LOCALIZACAO_IMAGEM, "Terra");
        }

    }

    private final Desenho GRAMA = new Grama();
    private final Desenho TERRA = new Terra();

    private boolean caminho;
    public final Formato formato;

    public Chao(Formato formato) {
        this.formato = formato;
        GRAMA.setFormato(formato);
        TERRA.setFormato(formato);

    }

    @Override
    public void paint(Graphics2D g) {
        if (caminho) {
            TERRA.paint(g);
        } else {
            GRAMA.paint(g);
        }

    }

    @Override
    public void update() {
        caminho = true;
    }

    public boolean isCaminho() {
        return caminho;
    }

    @Override
    public String toString() {
        return "Chao{" + "caminho=" + caminho + ", formato=" + formato + '}';
    }

    
    
}
