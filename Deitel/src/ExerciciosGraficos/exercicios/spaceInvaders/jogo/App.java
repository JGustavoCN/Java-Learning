package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

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
        JFrame janela = new JFrame();
        //janela.setSize(1366, 768);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setUndecorated(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        return janela;
    }
    
}
