package jogo;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Gustavo
 */
public class PlayManager implements Desenhavel, Atualizavel {

    public static List<Chao> chao = new ArrayList();
    Chao chaoo;
    Chao chaooo;
    int pinta = 0;

    public PlayManager() {
        for (int i = 0; i < 25; i++) {
            System.out.println(i % 5 * 100 + " - " + i / 5 * 100);
            chao.add(new Chao(i % 5 * 100, i / 5 * 100));
        }
        chaoo = new Chao(0 % 5 * 100, 0 / 5 * 100);
        chaooo = new Chao(0, 0);
    }

    @Override
    public void paint(Graphics2D g2) {
        
        for (int i = 0; i < chao.size(); i++) {
            System.out.println(i+" - "+chao.get(i));
            chao.get(i).paint(g2);
        }
        
        //chaooo.paint(g2);

    }

    @Override
    public void update() {
        for (int i = 0; i < chao.size(); i++) {
            chao.get(i).update();
            
        }
    }

}
