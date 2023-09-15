package ExerciciosNormais.exercicios.Jogos;

/**
 *
 * Explicação do jogo Craps: Você lança dois dados. Cada dado tem seis faces que
 * contêm um, dois, três, quatro, cinco e seis pontos, respectivamente. Depois
 * que os dados param de rolar, a soma dos pontos nas faces viradas para cima é
 * calculada. Se a soma for 7 ou 11 no primeiro lance, você ganha. Se a soma for
 * 2, 3 ou 12 no primeiro lance (chamado “craps”), você perde (isto é, a “casa”
 * ganha). Se a soma for 4, 5, 6, 8, 9 ou 10 no primeiro lance, essa soma torna-
 * -se sua “pontuação”. Para ganhar, você deve continuar a rolar os dados até
 * “fazer sua pontuação” (isto é, obter um valor igual à sua pontuação). Você
 * perde se obtiver um 7 antes de fazer sua pontuação.
 *
 * @author José Gustavo
 *
 */
import java.security.SecureRandom;

public class Craps implements Jogavel {

    private enum Status {
        CONTINUE, WON, LOST
    }

    private static final SecureRandom randomNumbers = new SecureRandom();

    /*
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
     */
    private static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        System.out.printf("Jogador rolou %d + %d = %d%n", die1, die2, sum);
        return sum;
    }

    @Override
    public void jogar() {

        int sumOfDice = rollDice();
        int myPoints = 0;
        Status gameStatus;

        if (sumOfDice == JogadasComuns.SEVEN.getValor() || sumOfDice == JogadasComuns.YO_LEVEN.getValor()) {
            gameStatus = Status.WON;
        } else if (sumOfDice == JogadasComuns.SNAKE_EYES.getValor() || sumOfDice == JogadasComuns.TREY.getValor() || sumOfDice == JogadasComuns.BOX_CARS.getValor()) {
            gameStatus = Status.LOST;
        } else {
            gameStatus = Status.CONTINUE;
            myPoints = sumOfDice;
            System.out.println("Meus Pontos: " + myPoints);
        }

        /* Esse funciona normalmente uso constantes da propria classe
        switch (sumOfDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoints = sumOfDice;
                System.out.println("My Points: " + myPoints);
                break;
        }
         */
        
         /* Esse nao funciona e nao aparece as sugestoes de erros 
        switch (sumOfDice) {
            case JogadasComuns.SEVEN.getValor():
            case JogadasComuns.YO_LEVEN.getValor():
                gameStatus = Status.WON;
                break;
            case JogadasComuns.SNAKE_EYES.getValor():
            case JogadasComuns.TREY.getValor():
            case JogadasComuns.BOX_CARS.getValor():
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoints = sumOfDice;
                System.out.println("My Points: "+ myPoints);
                break;
        }
         */
        
        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();
            if (sumOfDice == JogadasComuns.SEVEN.getValor()) {
                gameStatus = Status.LOST;
            } else if (sumOfDice == myPoints) {
                gameStatus = Status.WON;
            }
        }

        if (gameStatus == Status.WON) {
            System.out.println("Ganhou");
        } else {
            System.out.println("Perdeu");
        }

    }

}
