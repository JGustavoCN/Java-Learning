package jogo.main;

import javax.swing.JFrame;

/**
 *
 * @author José Gustavo
 */
public class AppJogo {

    public static JFrame janela;
 
    public static void main(String[] args) {
       
        janela = new JFrame();
        GamePanel gp = new GamePanel();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.add(gp);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        gp.launchGame();
//        janela.addKeyListener(jogo);
        
        
    }
    
    
    
}
