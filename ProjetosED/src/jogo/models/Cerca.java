package jogo.models;

import java.awt.Graphics2D;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Desenho;
import jogo.abstracts.Formato;
import jogo.models.Chao.Grama;

/**
 *
 * @author José Gustavo
 */
public class Cerca implements Desenhavel{

    public class DesenhoCerca extends Desenho {

        public DesenhoCerca(String localizacaoDaImagem, String nome) {
            super(localizacaoDaImagem, nome);
        }

    }

    private final Grama grama = new Chao.Grama();
    public Desenho desenhoCerca;
    public static final int CANTO_SE = 0;
    public static final int MEIO_H = 1;
    public static final int CANTO_SD = 2;
    public static final int CANTO_SE_2 = 3;
    public static final int MEIO_V = 4;
    public static final int CANTO_ID = 5;
    public static final int CANTO_IE = 6;
    public static final int CANTO_ID_2 = 7;

    public Cerca(int tipoCerca, Formato formato) {

        desenhoCerca = new DesenhoCerca("src/jogo/imagens/cerca/cerca" + (tipoCerca + 1) + ".png", "trator" + (tipoCerca + 1));
        desenhoCerca.setFormato(formato);
        grama.setFormato(formato);

    }

    @Override
    public void paint(Graphics2D g) {
        grama.paint(g);
        desenhoCerca.paint(g);
    }
}
