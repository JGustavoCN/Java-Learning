package ExerciciosNormais.exercicios.Jogos;

import java.security.SecureRandom;
import static java.lang.Math.random;
import java.util.Random;

/**
 * Testando a geracao de numeros alaatorios
 * @author José Gustavo
 */
public class RandomIntegers {

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int face = secureRandom().nextInt(6) + 1;
                System.out.print(face + "  ");
            }
            System.out.println("");
        }

        System.out.println("");
//        rollDieNumber = 600;
        rollDieSecureRandom();
        System.out.println("");
        rollDieMathRandom();
        System.out.println("");
        rollDieRandom();

    }

    public static int rollDieNumber = 6_000_000;

    public static SecureRandom secureRandom() {
        SecureRandom randomNumbers = new SecureRandom();
        return randomNumbers;
    }
    
    public static void rollDieSecureRandom() {

        int arrayFrequency[] = new int[6];
        int indexFrequency;

        for (int roll = 0; roll < rollDieNumber; roll++) {
            int face = secureRandom().nextInt(6) + 1;
            switch (face) {
                case 1:
                    indexFrequency = 0;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 2:
                    indexFrequency = 1;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 3:
                    indexFrequency = 2;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 4:
                    indexFrequency = 3;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 5:
                    indexFrequency = 4;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 6:
                    indexFrequency = 5;
                    ++arrayFrequency[indexFrequency];
                    break;
            }
        }
        System.out.println("--> Roll Die with Secure Random");
        System.out.println("Face\tFrequency");
        for (int i = 0; i < arrayFrequency.length; i++) {
            System.out.printf("%3d\t%5d\n", (i + 1), arrayFrequency[i]);

        }

    }

    public static void rollDieMathRandom() {

        int arrayFrequency[] = new int[6];
        int indexFrequency;

        for (int roll = 0; roll < rollDieNumber; roll++) {
            int face = (int) (1 + random() * (7 - 1));
            switch (face) {
                case 1:
                    indexFrequency = 0;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 2:
                    indexFrequency = 1;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 3:
                    indexFrequency = 2;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 4:
                    indexFrequency = 3;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 5:
                    indexFrequency = 4;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 6:
                    indexFrequency = 5;
                    ++arrayFrequency[indexFrequency];
                    break;
            }
        }
        System.out.println("--> Roll Die with Math Random");
        System.out.println("Face\tFrequency");
        for (int i = 0; i < arrayFrequency.length; i++) {
            System.out.printf("%3d\t%5d\n", (i + 1), arrayFrequency[i]);

        }

    }

    public static void rollDieRandom() {

        Random random = new Random();
        int arrayFrequency[] = new int[6];
        int indexFrequency;

        for (int roll = 0; roll < rollDieNumber; roll++) {
            int face = random.nextInt(6) + 1;
            switch (face) {
                case 1:
                    indexFrequency = 0;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 2:
                    indexFrequency = 1;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 3:
                    indexFrequency = 2;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 4:
                    indexFrequency = 3;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 5:
                    indexFrequency = 4;
                    ++arrayFrequency[indexFrequency];
                    break;
                case 6:
                    indexFrequency = 5;
                    ++arrayFrequency[indexFrequency];
                    break;
            }
        }
        System.out.println("--> Roll Die with Random");
        System.out.println("Face\tFrequency");
        for (int i = 0; i < arrayFrequency.length; i++) {
            System.out.printf("%3d\t%5d\n", (i + 1), arrayFrequency[i]);

        }

    }

}
