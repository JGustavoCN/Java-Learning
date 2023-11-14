package ExerciciosGraficos.exercicios.tetris.mino.minos;

import ExerciciosGraficos.exercicios.tetris.mino.Block;
import ExerciciosGraficos.exercicios.tetris.mino.Mino;
import java.awt.Color;

/**
 *
 * @author José Gustavo
 */
public class Mino_Z2 extends Mino {

    public Mino_Z2() {
        create(Color.GREEN);
    }

    @Override
    public void setXY(int x, int y) {

        //   °
        //   ° °
        //     ° 
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getDirecao1() {
        //   °
        //   ° °
        //     ° 
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        updateXY(1);
    }

    @Override
    public void getDirecao2() {
        //   ° ° 
        // ° °
        //  
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        updateXY(2);
    }

    @Override
    public void getDirecao3() {
        getDirecao1();
    }

    @Override
    public void getDirecao4() {
        getDirecao2();
    }

}
