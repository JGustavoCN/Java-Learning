package Main;

/**
 * @author José Gustavo
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // questao da  monitoria
        Scanner teclado = new Scanner(System.in);
        int max = 100;
        int elementos[] = new int[max];
        int maior = 0;
        int repetidos[] = new int[max];
        int maiores_repeticoes[] = new int[max];
        int maior_numero_repeticao = 0;
        int k = 0;
        int a = 0;

        for (int i = 0; i < elementos.length; i++) {

            System.out.print("Digite um numero: ");
            elementos[i] = Integer.parseInt(teclado.nextLine());
            if (elementos[i] > maior) {
                maior = elementos[i];
            }
            if (elementos[i] == 0) {
                break;
            }

        }

        for (int i = 1; i <= maior; i++) {

            for (int j = 0; j < elementos.length; j++) {
                if (elementos[j] == 0) {
                    break;
                }
                if (elementos[j] == i) {
                    repetidos[a] = repetidos[a] + 1;
                }
            }

            if (repetidos[a] > maior_numero_repeticao) {
                maiores_repeticoes[k] = i;
                maior_numero_repeticao = repetidos[a];
            } else if (repetidos[a] == maior_numero_repeticao) {
                if (maior_numero_repeticao != 0) {
                    ++k;
                    maiores_repeticoes[k] = i;
                }
            }
            a++;
        }

        for (int elemento : elementos) {
            if (elemento == 0) {
                System.out.print("0 | ");
                break;
            } else {
                System.out.print(elemento + " | ");
            }

        }
        System.out.println("");
        for (int i : maiores_repeticoes) {
            if (i == 0) {
                continue;
            }
            System.out.print(i + " | ");
        }
        System.out.println("");
    }

}
