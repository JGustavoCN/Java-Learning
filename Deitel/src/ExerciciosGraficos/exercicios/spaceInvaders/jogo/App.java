package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import javax.swing.JFrame;

/**
 *
 * @author José Gustavo
 */
public class App {
    
    public static void main(String[] args) {
        JFrame janela = criarJanela();
        SpaceInvaders jogo = new SpaceInvaders();
        jogo.setBounds(0, 0, 1366, 768);
        janela.add(jogo);
        janela.addKeyListener(jogo);
    }
    
    public static JFrame criarJanela() {
        JFrame janela = new JFrame();
        janela.setSize(1366, 768);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        return janela;
    }
    
}
