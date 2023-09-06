package ExerciciosNormais.exercicios.Jogos;

/**
 *
 * @author José Gustavo
 */
public enum JogadasComuns {
//    Nao consigui usar no switch retornando o valor do enum
    SNAKE_EYES(2),
    TREY(3),
    SEVEN(7),
    YO_LEVEN(11),
    BOX_CARS(12);

    private final int valor;

    private JogadasComuns(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}
