package jogo.abstracts;

/**
 *
 * @author José Gustavo
 */
public class Formato {
    
    public int x;
    public int y;
    public int tamanhoX;
    public int tamanhoY;

    public Formato(int x, int y, int tamanhoX, int tamanhoY) {
        this.x = x;
        this.y = y;
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
    }

    @Override
    public String toString() {
        return "Formato{" + "x=" + x + ", y=" + y + ", tamanhoX=" + tamanhoX + ", tamanhoY=" + tamanhoY + '}';
    }
    
    
}
