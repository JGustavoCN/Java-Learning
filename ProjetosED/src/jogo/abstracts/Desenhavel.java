package jogo.abstracts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author José Gustavo
 */
public interface Desenhavel {
    
     //Faz sentido essa interface ja que precusa de um atributo
    void paint(Graphics2D g);
    
    /**
     * 
     * @param g2 Use o Grafics geral do jogo e crie uma nova variavel para receber
     * um Graphics2D para ativar o AntiAliasing
     * @return Graphics2D
     */
    default Graphics2D ativarAntiAliasing(Graphics g2){
        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING, 
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        return g;
        
    }
}
