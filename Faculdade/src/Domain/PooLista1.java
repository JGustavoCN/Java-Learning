package Domain;

import java.util.Scanner;
import java.util.Arrays;
import static java.lang.Math.*;

/**
 *
 * @author José Gustavo
 */
class PooLista1 {

    public static void main(String[] args) {
        
        PooLista1 main = new PooLista1();
        media();
        System.out.println();
        System.out.print("Digite uma string: ");
        main.inverterString(teclado.nextLine());
        System.out.println();
        int[] numeros = new int[5];
        Arrays.fill(numeros, 1);
        numeros[0] = 5;
        maiorEMenor(numeros);
        System.out.println();
        medidasCirculo(5);

    }

    public static final Scanner teclado = new Scanner(System.in);

    public static void medidasCirculo(double raio) {

        // 4. Escreva um programa Java que calcule a área e o perímetro de um círculo.
        // O usuário deve inserir o raio como entrada.
        double perimetro = 2 * PI * raio;
        double area = PI * pow(raio, 2);
        System.out.print("Perimetro: " + perimetro + "\nArea: " + area);

    }

    public static void maiorEMenor(int... numeros) {

        //3. Escreva um programa Java para encontrar o maior e o menor número em um array de inteiros. O programa deve
        //iterar através do array e identificar esses valores.
        Arrays.sort(numeros);
        System.out.print("Maior: " + numeros[numeros.length - 1] + "\nMenor: " + numeros[0]);

    }

    public String inverterString(String string) {

        //2. Implemente um programa Java que leia uma string do usuário e inverta essa string.
        //Por exemplo, se o usuário inserir "Java", o programa deve retornar "avaJ".
        StringBuilder stringBuilder = new StringBuilder(string);
        String invertida = stringBuilder.reverse().toString();
        System.out.print(invertida);
        return invertida;

    }

    public static double media() {

        // 1. Escreva um programa Java para calcular a média de 5 números.   
        // Use arrays para armazenar os números.
        final int max = 5;
        int[] numeros = new int[max];
        double media = 0; 
        int sum = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite um numero: ");
            numeros[i] = Integer.parseInt(teclado.nextLine());
            sum += numeros[i];
        }
        media = ((double) sum) / max;
        System.out.println("Media: " + media);
        return media;

    }

}
