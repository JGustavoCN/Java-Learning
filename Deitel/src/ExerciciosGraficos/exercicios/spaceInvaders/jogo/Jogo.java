package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author José Gustavo
 */
public abstract class Jogo extends JPanel implements Runnable, KeyListener, Desenhavel, Atualizavel {

    public abstract void sleep(long duracao);
 
}
