package ExerciciosGraficos.exercicios.tetris.main;

import javax.swing.JFrame;

/**
 *
 * @author José Gustavo
 */
public class AppTetris {
    public static void main(String[] args) {
        
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        GamePanel gp = new GamePanel();
        janela.add(gp);
        janela.pack();//O que é esse metodo
        
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
        gp.launchGame();
    }
    
}
