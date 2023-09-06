package ExerciciosGraficos.exercicios.Linhas;

/**
 *
 * @author José Gustavo
 */
// Utilizando DrawLine para conectar os cantos de um painel.
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

    // desenha um X a partir dos cantos do painel
    /**
     * O método paintComponent deve ser declarado conforme mostrado — caso
     * contrário, o sistema não o chamará. Esse método é chamado quando um
     * JPanel é exibido na tela pela primeira vez, quando é ocultado e então
     * exibido por uma janela na tela e quando a janela em que aparece é
     * redimensionada. O método paintComponent requer um argumento, um objeto de
     * Graphics, que é oferecido pelo sistema quando ele chama paintComponent.
     * Esse objeto Graphics é usado para desenhar linhas, retângulos, ovais e
     * outros elementos gráficos.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {

        // chama paintComponent para assegurar que o painel é exibido corretamente
        super.paintComponent(g);

//Se você redimensionar a janela, as linhas serão dimensionadas de maneira correspondente, 
//uma vez que os argumentos estão baseados na largura e altura do painel. Redimensionar a janela nesse
//aplicativo resulta em uma chamada de sistema paintComponent para redesenhar o conteúdo de DrawPanel.

        int largura = getWidth(); // largura total 
        int altura = getHeight(); // altura total

// 4.1 Utilizar loops e instruções de controle para desenhar linhas pode levar a muitos projetos interessantes. (Pág 107-108)
//
//    a) Crie o projeto na captura de tela esquerda da Figura 4.20. Esse projeto desenha linhas do canto superior esquerdo, estendendo-as até
//       que cubram a metade superior esquerda do painel. Uma abordagem é dividir a largura e altura em um número igual de passos (descobrimos
//       que 15 passos funcionam bem). A primeira extremidade de uma linha sempre estará no canto superior esquerdo (0, 0).
//
//       A segunda extremidade pode ser encontrada iniciando no canto inferior esquerdo e movendo-se para cima em um passo vertical e para
//       a direita em um passo horizontal. Desenhe uma linha entre as duas extremidades. Continue movendo-se para cima e para o passo à
//       direita a fim de encontrar cada extremidade sucessiva. A figura deve ser dimensionada de maneira correspondente à medida que você
//       redimensiona a janela.
//
//    b) Modifique sua resposta da parte (a) para que as linhas se estendam dos quatro cantos, as linhas de cantos opostos devem se cruzar no meio.

        // número de passos
        int nPassos = 15;

        // tamanho dos passos ( 15 passos )
        int passoX = largura / nPassos;
        int passoY = altura / nPassos;

        int c = 1; // contador

        // desenhando
        while (c <= nPassos) {
           
            //(a)
            // origem superior esquerda 
            g.drawLine(0, 0, passoX * c, altura - (passoY * c));
            
            //(b)
            // origem superior direita
            g.drawLine(largura, 0, largura - (passoX * c), altura - (passoY * c));

            // origem inferior esquerda
            g.drawLine(0, altura, largura - (passoX * c), altura - (passoY * c));

            // origem inferior direita
            g.drawLine(largura, altura, passoX * c, altura - (passoY * c));

            // incrementa contador
            c++;

        }

        // desenha uma linha a partir do canto superior esquerdo até o inferior direito
        // g.drawLine(0, 0, largura, altura);
    }

}
