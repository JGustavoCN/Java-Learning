package br.edu.ifs.poo.listas;

/**
 * @author José Gustavo
 */
import java.util.Arrays;
import java.util.Scanner;

public class Monitoria {

    public static void main(String[] args) {

        // Questao da  monitoria Terminei?
       
        Scanner teclado = new Scanner(System.in);
        int max = 100000;
        int elementos[] = new int[max];
        int maior = 0;
        int repetidos[] = new int[max];
        int maiores_repeticoes[] = new int[max];
        int maior_numero_repeticao = 0;
        int maior_numero_repeticao_serie = 0;
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
                maior_numero_repeticao = repetidos[a];
                if (maior_numero_repeticao > maior_numero_repeticao_serie) {
                    k = 0;
                    Arrays.fill(maiores_repeticoes, 0);
                }
                maiores_repeticoes[k] = i;
            } else if (repetidos[a] == maior_numero_repeticao) {

                if (maior_numero_repeticao != 0) {
                    maior_numero_repeticao_serie = maior_numero_repeticao;
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
                break;
            }
            System.out.print(i + " | ");
        }
        System.out.println("");
    }

}
