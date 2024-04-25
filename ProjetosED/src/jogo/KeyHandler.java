package jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author José Gustavo
 */
public class KeyHandler implements KeyListener {

    public static boolean upPressed, downPressed, leftPressed, rightPressed, pausePressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            PlayManager.player.cima();
        } else if (code == KeyEvent.VK_A) {
            PlayManager.player.esquerda();
        } else if (code == KeyEvent.VK_S) {
            PlayManager.player.baixo();
        } else if (code == KeyEvent.VK_D) {
            PlayManager.player.direita();
        } else if (code == KeyEvent.VK_Q) {
            PlayManager.player.esquerda();
            PlayManager.player.cima();
        } else if (code == KeyEvent.VK_E) {
            PlayManager.player.direita();
            PlayManager.player.cima();
        } else if (code == KeyEvent.VK_Z) {
            PlayManager.player.esquerda();
        } else if (code == KeyEvent.VK_C) {
            PlayManager.player.direita();
            PlayManager.player.baixo();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
