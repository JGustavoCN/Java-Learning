package jogo.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author José Gustavo
 */
public class KeyHandler implements KeyListener {

    public static boolean cima, baixo, esquerda, direita, cantoSupE, cantoSupD, cantoInfE, cantoInfD;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (PlayManager.local) {
            case CANTO_SUPERIOR_ESQUERDO:
                switch (code) {
                    case KeyEvent.VK_S:
                        baixo = true;
                        break;
                    case KeyEvent.VK_D:
                        direita = true;
                        break;
                    case KeyEvent.VK_C:
                        cantoInfD = true;
                        break;
                }
                break;

            case MEIO_SUPERIOR:
                switch (code) {
                    case KeyEvent.VK_A:
                        esquerda = true;
                        break;
                    case KeyEvent.VK_S:
                        baixo = true;
                        break;
                    case KeyEvent.VK_D:
                        direita = true;
                        break;
                    case KeyEvent.VK_Z:
                        cantoInfE = true;
                        break;
                    case KeyEvent.VK_C:
                        cantoInfD = true;
                        break;
                }

                break;
            case CANTO_SUPERIOR_DIREITO:
                switch (code) {
                    case KeyEvent.VK_A:
                        esquerda = true;
                        break;
                    case KeyEvent.VK_S:
                        baixo = true;
                        break;

                    case KeyEvent.VK_Z:
                        cantoInfE = true;
                        break;
                }
                break;
            case MEIO_ESQUERDO:
                switch (code) {
                    case KeyEvent.VK_W:
                        cima = true;
                        break;
                    case KeyEvent.VK_S:
                        baixo = true;
                        break;
                    case KeyEvent.VK_D:
                        direita = true;
                        break;
                    case KeyEvent.VK_E:
                        cantoSupD = true;
                        break;
                    case KeyEvent.VK_C:
                        cantoInfD = true;
                        break;
                }
                break;
            case MEIO:
                switch (code) {
                    case KeyEvent.VK_W:
                        cima = true;
                        break;
                    case KeyEvent.VK_A:
                        esquerda = true;
                        break;
                    case KeyEvent.VK_S:
                        baixo = true;
                        break;
                    case KeyEvent.VK_D:
                        direita = true;
                        break;
                    case KeyEvent.VK_Q:
                        cantoSupE = true;
                        break;
                    case KeyEvent.VK_E:
                        cantoSupD = true;
                        break;
                    case KeyEvent.VK_Z:
                        cantoInfE = true;
                        break;
                    case KeyEvent.VK_C:
                        cantoInfD = true;
                        break;
                }
                break;
            case MEIO_DIREITO:
                switch (code) {
                    case KeyEvent.VK_W:
                        cima = true;
                        break;
                    case KeyEvent.VK_A:
                        esquerda = true;
                        break;
                    case KeyEvent.VK_S:
                        baixo = true;
                        break;
                    case KeyEvent.VK_Q:
                        cantoSupE = true;
                        break;
                    case KeyEvent.VK_Z:
                        cantoInfE = true;
                        break;
                }
                break;
            case CANTO_INFERIOR_ESQUERDO:
                switch (code) {
                    case KeyEvent.VK_W:
                        cima = true;
                        break;
                    case KeyEvent.VK_D:
                        direita = true;
                        break;
                    case KeyEvent.VK_E:
                        cantoSupD = true;
                        ;
                        break;
                }
                break;
            case MEIO_INFERIOR:
                switch (code) {
                    case KeyEvent.VK_W:
                        cima = true;
                        break;
                    case KeyEvent.VK_A:
                        esquerda = true;
                        break;
                    case KeyEvent.VK_D:
                        direita = true;
                        break;
                    case KeyEvent.VK_Q:
                        cantoSupE = true;
                        break;
                    case KeyEvent.VK_E:
                        cantoSupD = true;
                        break;
                }
                break;
            case CANTO_INFERIOR_DIREITO:
                switch (code) {
                    case KeyEvent.VK_W:
                        cima = true;
                        break;
                    case KeyEvent.VK_A:
                        esquerda = true;
                        break;
                    case KeyEvent.VK_Q:
                        cantoSupE = true;
                        break;
                    case KeyEvent.VK_E:
                        cantoSupD = true;
                        break;
                }
                break;
            default:
                System.out.println("Local não existe - KeyHandler");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
