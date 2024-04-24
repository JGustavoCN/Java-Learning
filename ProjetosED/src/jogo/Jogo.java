package jogo;


import javax.swing.JPanel;

/**
 *
 * @author José Gustavo
 */
public abstract class Jogo extends JPanel implements Runnable, Atualizavel {

    public abstract void sleep(long duracao);
 
}
