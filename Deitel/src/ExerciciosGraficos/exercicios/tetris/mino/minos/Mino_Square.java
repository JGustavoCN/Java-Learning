package ExerciciosGraficos.exercicios.tetris.mino.minos;

import ExerciciosGraficos.exercicios.tetris.mino.Block;
import ExerciciosGraficos.exercicios.tetris.mino.Mino;
import java.awt.Color;

/**
 *
 * @author José Gustavo
 */
public class Mino_Square extends Mino {

    public Mino_Square() {
        create(Color.YELLOW);
    }

    @Override
    public void setXY(int x, int y) {

        // ° ° 
        // ° °
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Block.SIZE;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getDirecao1() {}

    @Override
    public void getDirecao2() {}

    @Override
    public void getDirecao3() {}

    @Override
    public void getDirecao4() {}
}
