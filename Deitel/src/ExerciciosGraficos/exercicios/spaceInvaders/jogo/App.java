package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import ExerciciosGraficos.exercicios.tetris.main.AppTetris;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 *
 * @author José Gustavo
 */
public class App {
    
    public static final DisplayMode tela = 
                GraphicsEnvironment.
                        getLocalGraphicsEnvironment().
                        getDefaultScreenDevice().
                        getDisplayMode();
    public static JFrame janela;
 
    public static void main(String[] args) {
       
        janela = criarJanela();
        SpaceInvaders jogo = new SpaceInvaders();
        jogo.setBounds(0, 0, tela.getWidth(), tela.getHeight());
        jogo.playMusic(Som.SPACE_BATTLE);
        janela.add(jogo);
        janela.addKeyListener(jogo);
        
        
    }
    
    public static JFrame criarJanela() {
        JFrame criarJanela = new JFrame();
//        criarJanela.setSize(1366, 768);

        //criarJanela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        criarJanela.setUndecorated(true);
        criarJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //criarJanela.setLayout(null);
        criarJanela.setResizable(false);
        criarJanela.pack();
        criarJanela.setLocationRelativeTo(null);
        criarJanela.setVisible(true);
        return criarJanela;
    }
    
}
